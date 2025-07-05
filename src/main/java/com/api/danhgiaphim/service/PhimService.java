package com.api.danhgiaphim.service;

import com.api.danhgiaphim.dto.request.PhimRequest;
import com.api.danhgiaphim.entity.DaoDien;
import com.api.danhgiaphim.entity.Phim;
import com.api.danhgiaphim.repository.DaoDienRepository;
import com.api.danhgiaphim.repository.DienVienRepository;
import com.api.danhgiaphim.repository.PhimRepository;
import com.api.danhgiaphim.repository.ReviewRepository;
import com.api.danhgiaphim.repository.TheLoaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhimService {

    @Autowired
    private PhimRepository phimRepo;
    @Autowired
    private DaoDienRepository daoDienRepo;
    @Autowired
    private TheLoaiRepository theLoaiRepo;
    @Autowired
    private DienVienRepository dienVienRepo;
    @Autowired
    private ReviewRepository reviewRepo;

    public Phim createPhim(PhimRequest request) {
        if (phimRepo.existsByTieuDeIgnoreCase(request.getTieuDe())) {
            throw new RuntimeException("Tiêu đề phim đã tồn tại");
        }

        DaoDien daoDien = daoDienRepo.findById(request.getMaDaoDien())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đạo diễn"));

        Phim phim = new Phim();
        setFields(phim, request, daoDien);
        return phimRepo.save(phim);
    }

    public List<Phim> getPhims() {
        return phimRepo.findAll();
    }

    public Phim getPhimById(Integer id) {
        return phimRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phim với mã: " + id));
    }

    public Phim updatePhim(Integer id, PhimRequest request) {
        Phim phim = getPhimById(id);

        if (!phim.getTieuDe().equalsIgnoreCase(request.getTieuDe())
                && phimRepo.existsByTieuDeIgnoreCase(request.getTieuDe())) {
            throw new RuntimeException("Tiêu đề phim đã tồn tại");
        }

        DaoDien daoDien = daoDienRepo.findById(request.getMaDaoDien())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đạo diễn"));

        setFields(phim, request, daoDien);
        return phimRepo.save(phim);
    }

    public void deletePhim(Integer id) {
        if (!phimRepo.existsById(id)) {
            throw new RuntimeException("Không tìm thấy phim để xoá");
        }
        phimRepo.deleteById(id);
    }

    private void setFields(Phim phim, PhimRequest req, DaoDien daoDien) {
        phim.setTieuDe(req.getTieuDe());
        phim.setPoster(req.getPoster());
        phim.setThoiLuong(req.getThoiLuong());
        phim.setNgayPhatHanh(req.getNgayPhatHanh());
        phim.setMoTa(req.getMoTa());
        phim.setDaoDien(daoDien);

        if (req.getMaDienVienList() != null) {
            phim.setDienViens(dienVienRepo.findAllById(req.getMaDienVienList()));
        }

        if (req.getMaTheLoaiList() != null) {
            phim.setTheLoais(theLoaiRepo.findAllById(req.getMaTheLoaiList()));
        }
    }

    public void updateOverallRating(Integer phimId) {
        Double newRating = reviewRepo.calculateAverageRatingByPhimId(phimId);

        Phim phimToUpdate = getPhimById(phimId);

        if (newRating != null) {
            double roundedRating = Math.round(newRating * 10.0) / 10.0;
            phimToUpdate.setOverallRating(roundedRating);
        } else {
            phimToUpdate.setOverallRating(0.0);
        }

        phimRepo.save(phimToUpdate);
    }
}
