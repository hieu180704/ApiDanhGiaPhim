package com.api.danhgiaphim.Controller;

import com.api.danhgiaphim.dto.request.PhimRequest;
import com.api.danhgiaphim.entity.DaoDien;
import com.api.danhgiaphim.entity.Phim;
import com.api.danhgiaphim.service.PhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/phims")
public class PhimController {

    @Autowired
    private PhimService phimService;

    @GetMapping
    public List<Phim> getAllPhim() {
        return phimService.findAll();
    }

    @GetMapping("/{maPhim}")
    public ResponseEntity<Phim> getPhimById(@PathVariable String maPhim) {
        return phimService.findById(maPhim)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Phim> createPhim(@Valid @RequestBody PhimRequest phimRequest) {
        Phim phim = new Phim();
        phim.setTieuDe(phimRequest.getTieuDe());
        phim.setPoster(phimRequest.getPoster());
        phim.setThoiLuong(phimRequest.getThoiLuong());
        phim.setNgayPhatHanh(phimRequest.getNgayPhatHanh());
        phim.setMoTa(phimRequest.getMoTa());
        // Gán khóa ngoại
        DaoDien daoDien = new DaoDien();
        daoDien.setMaDaoDien(phimRequest.getMaDaoDien());
        phim.setDaoDien(daoDien);

        Phim savedPhim = phimService.savePhim(phim);
        return ResponseEntity.ok(savedPhim);
    }

    @PutMapping("/{maPhim}")
    public ResponseEntity<Phim> updatePhim(@PathVariable String maPhim, @Valid @RequestBody PhimRequest phimRequest) {
        return phimService.findById(maPhim)
                .map(phim -> {
                    phim.setTieuDe(phimRequest.getTieuDe());
                    phim.setPoster(phimRequest.getPoster());
                    phim.setThoiLuong(phimRequest.getThoiLuong());
                    phim.setNgayPhatHanh(phimRequest.getNgayPhatHanh());
                    phim.setMoTa(phimRequest.getMoTa());
                    DaoDien daoDien = new DaoDien();
                    daoDien.setMaDaoDien(phimRequest.getMaDaoDien());
                    phim.setDaoDien(daoDien);
                    return ResponseEntity.ok(phimService.savePhim(phim));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{maPhim}")
    public ResponseEntity<Void> deletePhim(@PathVariable String maPhim) {
        if (phimService.findById(maPhim).isPresent()) {
            phimService.deleteById(maPhim);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}