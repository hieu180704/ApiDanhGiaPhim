package com.api.danhgiaphim.service;

import com.api.danhgiaphim.entity.Phim;
import com.api.danhgiaphim.entity.TheLoai;
import com.api.danhgiaphim.entity.TheLoaiPhim;
import com.api.danhgiaphim.entity.TheLoaiPhimId;
import com.api.danhgiaphim.repository.PhimRepository;
import com.api.danhgiaphim.repository.TheLoaiPhimRepository;
import com.api.danhgiaphim.repository.TheLoaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheLoaiPhimService {

    @Autowired
    private TheLoaiPhimRepository theLoaiPhimRepository;

    @Autowired
    private PhimRepository phimRepository;

    @Autowired
    private TheLoaiRepository theLoaiRepository;

    public TheLoaiPhim saveTheLoaiPhim(String maPhim, Integer maTheLoai) {
        Phim phim = phimRepository.findById(maPhim)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phim với mã: " + maPhim));
        TheLoai theLoai = theLoaiRepository.findById(maTheLoai)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thể loại với mã: " + maTheLoai));

        TheLoaiPhimId id = new TheLoaiPhimId(maPhim, maTheLoai);
        TheLoaiPhim theLoaiPhim = new TheLoaiPhim();
        theLoaiPhim.setId(id);
        theLoaiPhim.setPhim(phim);
        theLoaiPhim.setTheLoai(theLoai);

        return theLoaiPhimRepository.save(theLoaiPhim);
    }

    public List<TheLoaiPhim> findAll() {
        return theLoaiPhimRepository.findAll();
    }

    public Optional<TheLoaiPhim> findById(String maPhim, Integer maTheLoai) {
        TheLoaiPhimId id = new TheLoaiPhimId(maPhim, maTheLoai);
        return theLoaiPhimRepository.findById(id);
    }

    public void deleteById(String maPhim, Integer maTheLoai) {
        TheLoaiPhimId id = new TheLoaiPhimId(maPhim, maTheLoai);
        theLoaiPhimRepository.deleteById(id);
    }
}