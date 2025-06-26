package com.api.danhgiaphim.controller;

import com.api.danhgiaphim.dto.request.DienVienPhimRequest;
import com.api.danhgiaphim.entity.DienVienPhim;
import com.api.danhgiaphim.service.DienVienPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dienvienphims")
public class DienVienPhimController {

    @Autowired
    private DienVienPhimService dienVienPhimService;

    @GetMapping
    public ResponseEntity<List<DienVienPhim>> getAllDienVienPhim() {
        return ResponseEntity.ok(dienVienPhimService.findAll());
    }

    @GetMapping("/{maDienVien}/{maPhim}")
    public ResponseEntity<DienVienPhim> getDienVienPhimById(@PathVariable Integer maDienVien, @PathVariable String maPhim) {
        return dienVienPhimService.findById(maDienVien, maPhim)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DienVienPhim> createDienVienPhim(@Valid @RequestBody DienVienPhimRequest request) {
        DienVienPhim dienVienPhim = dienVienPhimService.saveDienVienPhim(request.getMaDienVien(), request.getMaPhim());
        return ResponseEntity.ok(dienVienPhim);
    }

    @DeleteMapping("/{maDienVien}/{maPhim}")
    public ResponseEntity<Void> deleteDienVienPhim(@PathVariable Integer maDienVien, @PathVariable String maPhim) {
        if (dienVienPhimService.findById(maDienVien, maPhim).isPresent()) {
            dienVienPhimService.deleteById(maDienVien, maPhim);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}