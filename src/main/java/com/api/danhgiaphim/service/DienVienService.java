package com.api.danhgiaphim.service;

import com.api.danhgiaphim.dto.request.DienVienRequest;
import com.api.danhgiaphim.entity.DienVien;
import com.api.danhgiaphim.repository.DienVienRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DienVienService {

    @Autowired
    private DienVienRepository dienVienRepository;

    public List<DienVien> getDienViens() {
        return dienVienRepository.findAll();
    }

    public DienVien getDienVien(Integer id) {
        return dienVienRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy diễn viên"));
    }

    public DienVien createDienVien(DienVienRequest request) {
        DienVien dienVien = new DienVien();
        dienVien.setTenDienVien(request.getTenDienVien());
        dienVien.setAnhDienVien(request.getAnhDienVien());
        dienVien.setNgaySinh(request.getNgaySinh());
        dienVien.setQuocGia(request.getQuocGia());

        return dienVienRepository.save(dienVien);
    }

    public DienVien updateDienVien(Integer id, DienVienRequest request) {
        DienVien dienVien = getDienVien(id);
        dienVien.setTenDienVien(request.getTenDienVien());
        dienVien.setAnhDienVien(request.getAnhDienVien());
        dienVien.setNgaySinh(request.getNgaySinh());
        dienVien.setQuocGia(request.getQuocGia());

        return dienVienRepository.save(dienVien);
    }

    public void deleteDienVien(Integer id) {
        dienVienRepository.deleteById(id);
    }
}
