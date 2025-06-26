package com.api.danhgiaphim.service;

import com.api.danhgiaphim.entity.DienVien;
import com.api.danhgiaphim.entity.DienVienPhim;
import com.api.danhgiaphim.entity.DienVienPhimId;
import com.api.danhgiaphim.entity.Phim;
import com.api.danhgiaphim.repository.DienVienPhimRepository;
import com.api.danhgiaphim.repository.DienVienRepository;
import com.api.danhgiaphim.repository.PhimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DienVienPhimService {

    @Autowired
    private DienVienPhimRepository dienVienPhimRepository;

    @Autowired
    private DienVienRepository dienVienRepository;

    @Autowired
    private PhimRepository phimRepository;

    public DienVienPhim saveDienVienPhim(Integer maDienVien, String maPhim) {
        DienVien dienVien = dienVienRepository.findById(maDienVien)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy diễn viên với mã: " + maDienVien));
        Phim phim = phimRepository.findById(maPhim)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phim với mã: " + maPhim));

        DienVienPhimId id = new DienVienPhimId(maDienVien, maPhim);
        DienVienPhim dienVienPhim = new DienVienPhim();
        dienVienPhim.setId(id);
        dienVienPhim.setDienVien(dienVien);
        dienVienPhim.setPhim(phim);

        return dienVienPhimRepository.save(dienVienPhim);
    }

    public List<DienVienPhim> findAll() {
        return dienVienPhimRepository.findAll();
    }

    public Optional<DienVienPhim> findById(Integer maDienVien, String maPhim) {
        DienVienPhimId id = new DienVienPhimId(maDienVien, maPhim);
        return dienVienPhimRepository.findById(id);
    }

    public void deleteById(Integer maDienVien, String maPhim) {
        DienVienPhimId id = new DienVienPhimId(maDienVien, maPhim);
        dienVienPhimRepository.deleteById(id);
    }
}