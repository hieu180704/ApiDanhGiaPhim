package com.api.danhgiaphim.Controller;

import com.api.danhgiaphim.entity.DienVien;
import com.api.danhgiaphim.service.DienVienService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
