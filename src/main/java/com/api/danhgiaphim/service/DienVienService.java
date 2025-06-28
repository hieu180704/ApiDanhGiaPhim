package com.api.danhgiaphim.service;

import com.api.danhgiaphim.dto.request.DienVienRequest;
import com.api.danhgiaphim.entity.DienVien;
import com.api.danhgiaphim.entity.QuocGia;
import com.api.danhgiaphim.exception.DuplicateResourceException;
import com.api.danhgiaphim.repository.DienVienRepository;
import com.api.danhgiaphim.repository.QuocGiaRepository;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DienVienService {

    @Autowired
    private DienVienRepository dienVienRepository;

    @Autowired
    private QuocGiaRepository quocGiaRepository;

    public List<DienVien> getDienViens() {
        return dienVienRepository.findAll();
    }

    public DienVien getDienVien(Integer id) {
        return dienVienRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy diễn viên với mã: " + id));
    }

    public DienVien createDienVien(@Valid DienVienRequest request) {
        if (dienVienRepository.existsByTenDienVienIgnoreCase(request.getTenDienVien())) {
            throw new DuplicateResourceException("Tên diễn viên đã tồn tại");
        }

        QuocGia quocGia = quocGiaRepository.findById(request.getMaQuocGia())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy quốc gia với mã: " + request.getMaQuocGia()));

        DienVien dienVien = new DienVien();
        dienVien.setTenDienVien(request.getTenDienVien());
        dienVien.setAnhDienVien(request.getAnhDienVien());
        dienVien.setNgaySinh(request.getNgaySinh());
        dienVien.setQuocGia(quocGia);

        return dienVienRepository.save(dienVien);
    }

    public DienVien updateDienVien(Integer id, @Valid DienVienRequest request) {
        DienVien dienVien = getDienVien(id);

        if (!dienVien.getTenDienVien().equalsIgnoreCase(request.getTenDienVien())
                && dienVienRepository.existsByTenDienVienIgnoreCase(request.getTenDienVien())) {
            throw new DuplicateResourceException("Tên diễn viên đã tồn tại");
        }

        QuocGia quocGia = quocGiaRepository.findById(request.getMaQuocGia())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy quốc gia với mã: " + request.getMaQuocGia()));

        dienVien.setTenDienVien(request.getTenDienVien());
        dienVien.setAnhDienVien(request.getAnhDienVien());
        dienVien.setNgaySinh(request.getNgaySinh());
        dienVien.setQuocGia(quocGia);

        return dienVienRepository.save(dienVien);
    }

    public void deleteDienVien(Integer id) {
        if (!dienVienRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy diễn viên để xoá, mã: " + id);
        }
        dienVienRepository.deleteById(id);
    }
}
