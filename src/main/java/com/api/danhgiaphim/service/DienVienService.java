package com.api.danhgiaphim.service;

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
}
