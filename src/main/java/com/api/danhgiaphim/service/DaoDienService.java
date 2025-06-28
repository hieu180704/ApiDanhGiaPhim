package com.api.danhgiaphim.service;

import com.api.danhgiaphim.dto.request.DaoDienRequest;
import com.api.danhgiaphim.entity.DaoDien;
import com.api.danhgiaphim.entity.QuocGia;
import com.api.danhgiaphim.exception.DuplicateResourceException;
import com.api.danhgiaphim.repository.DaoDienRepository;
import com.api.danhgiaphim.repository.QuocGiaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaoDienService {
    @Autowired
    private DaoDienRepository daoDienRepository;

    @Autowired
    private QuocGiaRepository quocGiaRepository;

    public List<DaoDien> getDaoDiens() {
        return daoDienRepository.findAll();
    }

    public DaoDien getDaoDien(Integer id) {
        return daoDienRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đạo diễn với mã: " + id));
    }

    public DaoDien createDaoDien(@Valid DaoDienRequest request) {
        if (daoDienRepository.existsByTenDaoDienIgnoreCase(request.getTenDaoDien())) {
            throw new DuplicateResourceException("Tên đạo diễn đã tồn tại");
        }

        QuocGia quocGia = quocGiaRepository.findById(request.getMaQuocGia())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy quốc gia với mã: " + request.getMaQuocGia()));

        DaoDien daoDien = new DaoDien();
        daoDien.setTenDaoDien(request.getTenDaoDien());
        daoDien.setAnhDaoDien(request.getAnhDaoDien());
        daoDien.setNgaySinh(request.getNgaySinh());
        daoDien.setQuocGia(quocGia);

        return daoDienRepository.save(daoDien);
    }

    public DaoDien updateDaoDien(Integer id, @Valid DaoDienRequest request) {
        DaoDien daoDien = getDaoDien(id);

        if (!daoDien.getTenDaoDien().equalsIgnoreCase(request.getTenDaoDien())
                && daoDienRepository.existsByTenDaoDienIgnoreCase(request.getTenDaoDien())) {
            throw new DuplicateResourceException("Tên đạo diễn đã tồn tại");
        }

        QuocGia quocGia = quocGiaRepository.findById(request.getMaQuocGia())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy quốc gia với mã: " + request.getMaQuocGia()));

        daoDien.setTenDaoDien(request.getTenDaoDien());
        daoDien.setAnhDaoDien(request.getAnhDaoDien());
        daoDien.setNgaySinh(request.getNgaySinh());
        daoDien.setQuocGia(quocGia);

        return daoDienRepository.save(daoDien);
    }

    public void deleteDaoDien(Integer id) {
        if (!daoDienRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy đạo diễn để xoá");
        }
        daoDienRepository.deleteById(id);
    }
}
