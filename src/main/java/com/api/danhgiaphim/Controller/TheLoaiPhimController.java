package com.api.danhgiaphim.controller;

import com.api.danhgiaphim.dto.request.TheLoaiPhimRequest;
import com.api.danhgiaphim.entity.TheLoaiPhim;
import com.api.danhgiaphim.service.TheLoaiPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/theloaiphims")
public class TheLoaiPhimController {

    @Autowired
    private TheLoaiPhimService theLoaiPhimService;

    @GetMapping
    public ResponseEntity<List<TheLoaiPhim>> getAllTheLoaiPhim() {
        return ResponseEntity.ok(theLoaiPhimService.findAll());
    }

    @GetMapping("/{maPhim}/{maTheLoai}")
    public ResponseEntity<TheLoaiPhim> getTheLoaiPhimById(@PathVariable String maPhim, @PathVariable Integer maTheLoai) {
        return theLoaiPhimService.findById(maPhim, maTheLoai)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TheLoaiPhim> createTheLoaiPhim(@Valid @RequestBody TheLoaiPhimRequest request) {
        TheLoaiPhim theLoaiPhim = theLoaiPhimService.saveTheLoaiPhim(request.getMaPhim(), request.getMaTheLoai());
        return ResponseEntity.ok(theLoaiPhim);
    }

    @DeleteMapping("/{maPhim}/{maTheLoai}")
    public ResponseEntity<Void> deleteTheLoaiPhim(@PathVariable String maPhim, @PathVariable Integer maTheLoai) {
        if (theLoaiPhimService.findById(maPhim, maTheLoai).isPresent()) {
            theLoaiPhimService.deleteById(maPhim, maTheLoai);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}