package com.api.danhgiaphim.service;

import com.api.danhgiaphim.entity.Phim;
import com.api.danhgiaphim.repository.PhimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhimService {

    @Autowired
    private PhimRepository phimRepository;

    public Phim savePhim(Phim phim) {
        return phimRepository.save(phim);
    }

    public Optional<Phim> findById(String maPhim) {
        return phimRepository.findById(maPhim);
    }

    public List<Phim> findAll() {
        return phimRepository.findAll();
    }

    public void deleteById(String maPhim) {
        phimRepository.deleteById(maPhim);
    }

    // Cập nhật rating dựa trên số lượt review 
    public void updateRating(String maPhim, Float newRating) {
        Optional<Phim> phimOpt = findById(maPhim);
        phimOpt.ifPresent(phim -> {
            phim.setOverallRating(newRating);
            phimRepository.save(phim);
        });
    }
}