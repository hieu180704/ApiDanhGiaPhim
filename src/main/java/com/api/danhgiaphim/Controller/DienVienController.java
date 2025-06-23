package com.api.danhgiaphim.Controller;

import com.api.danhgiaphim.dto.request.DienVienRequest;
import com.api.danhgiaphim.entity.DienVien;
import com.api.danhgiaphim.service.DienVienService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dienviens")
public class DienVienController {

    @Autowired
    private DienVienService dienVienService;

    @GetMapping
    public List<DienVien> selectDienVien() {
        return dienVienService.getDienViens();
    }

    @PostMapping
    DienVien createDienVien(@RequestBody DienVienRequest request) {
        return dienVienService.createDienVien(request);
    }

    @GetMapping("/{maDienVien}")
    DienVien selectDienVienById(@PathVariable("maDienVien") Integer maDienVien) {
        return dienVienService.getDienVien(maDienVien);
    }

    @PutMapping("/{maDienVien}")
    DienVien updateDienVien(@PathVariable("maDienVien") Integer maDienVien, @RequestBody DienVienRequest request) {
        return dienVienService.updateDienVien(maDienVien, request);
    }

    @DeleteMapping("/{maDienVien}")
    String xoaDienVien(@PathVariable("maDienVien") Integer maDienVien) {
        dienVienService.deleteDienVien(maDienVien);
        return "Đã Xoá Diễn Viên";
    }
}
