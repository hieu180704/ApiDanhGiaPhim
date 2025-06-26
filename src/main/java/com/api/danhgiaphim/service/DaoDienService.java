package com.api.danhgiaphim.service;

import com.api.danhgiaphim.dto.request.DaoDienRequest;
import com.api.danhgiaphim.entity.DaoDien;
import com.api.danhgiaphim.repository.DaoDienRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DaoDienService {

    @Autowired
    private DaoDienRepository daoDienRepository;

    public List<DaoDien> getDaoDiens() {
        return daoDienRepository.findAll();
    }

    public DaoDien getDaoDien(Integer id) {
        return daoDienRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy đạo diễn"));
    }

    public DaoDien createDaoDien(DaoDienRequest request) {
        DaoDien daoDien = new DaoDien();
        daoDien.setTenDaoDien(request.getTenDaoDien());
        daoDien.setAnhDaoDien(request.getAnhDaoDien());
        daoDien.setNgaySinh(request.getNgaySinh());
        daoDien.setQuocGia(request.getQuocGia());

        return daoDienRepository.save(daoDien);
    }

    public DaoDien updateDaoDien(Integer id, DaoDienRequest request) {
        DaoDien daoDien = getDaoDien(id);
        daoDien.setTenDaoDien(request.getTenDaoDien());
        daoDien.setAnhDaoDien(request.getAnhDaoDien());
        daoDien.setNgaySinh(request.getNgaySinh());
        daoDien.setQuocGia(request.getQuocGia());

        return daoDienRepository.save(daoDien);
    }

    public void deleteDaoDien(Integer id) {
        daoDienRepository.deleteById(id);
    }
}
