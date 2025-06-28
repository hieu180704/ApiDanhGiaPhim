package com.api.danhgiaphim.service;

import com.api.danhgiaphim.dto.request.QuocGiaRequest;
import com.api.danhgiaphim.entity.QuocGia;
import com.api.danhgiaphim.exception.DuplicateResourceException;
import com.api.danhgiaphim.repository.QuocGiaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuocGiaService {

    @Autowired
    private QuocGiaRepository quocGiaRepository;

    public QuocGia createQuocGia(QuocGiaRequest request) {
        if (quocGiaRepository.existsByTenQuocGiaIgnoreCase(request.getTenQuocGia())) {
            throw new DuplicateResourceException("Tên quốc gia đã tồn tại");
        }

        QuocGia quocGiaEntity = new QuocGia();
        quocGiaEntity.setTenQuocGia(request.getTenQuocGia());
        return quocGiaRepository.save(quocGiaEntity);
    }

    public List<QuocGia> saveAllQuocGias(List<QuocGia> quocGias) {
        return quocGiaRepository.saveAll(quocGias);
    }

    public List<QuocGia> getQuocGias() {
        return quocGiaRepository.findAll();
    }

    public QuocGia getQuocGia(Integer id) {
        return quocGiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy quốc gia với mã: " + id));
    }

    public QuocGia updateQuocGia(Integer id,QuocGiaRequest request) {
        QuocGia quocGia = getQuocGia(id);

        if (!quocGia.getTenQuocGia().equalsIgnoreCase(request.getTenQuocGia()) &&
            quocGiaRepository.existsByTenQuocGiaIgnoreCase(request.getTenQuocGia())) {
            throw new DuplicateResourceException("Tên quốc gia đã tồn tại");
        }

        quocGia.setTenQuocGia(request.getTenQuocGia());
        return quocGiaRepository.save(quocGia);
    }

    public void deleteQuocGia(Integer id) {
        if (!quocGiaRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy quốc gia để xoá, mã: " + id);
        }

        quocGiaRepository.deleteById(id);
    }
    
}
