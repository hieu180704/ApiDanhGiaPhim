package com.api.danhgiaphim.service;

import com.api.danhgiaphim.dto.request.TheLoaiRequest;
import com.api.danhgiaphim.entity.TheLoai;
import com.api.danhgiaphim.exception.DuplicateResourceException;
import com.api.danhgiaphim.repository.TheLoaiRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheLoaiService {

    @Autowired
    private TheLoaiRepository theLoaiRepository;

    public TheLoai createTheLoai(TheLoaiRequest request) {
        if (theLoaiRepository.existsByTenTheLoaiIgnoreCase(request.getTenTheLoai())) {
            throw new DuplicateResourceException("Tên thể loại đã tồn tại");
        }

        TheLoai theLoai = new TheLoai();
        theLoai.setTenTheLoai(request.getTenTheLoai());

        return theLoaiRepository.save(theLoai);
    }

    public List<TheLoai> getTheLoais() {
        return theLoaiRepository.findAll();
    }

    public TheLoai getTheLoais(Integer id) {
        return theLoaiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thể loại có mã: " + id));
    }

    public TheLoai updateTheLoai(Integer id, TheLoaiRequest request) {
        TheLoai theLoai = getTheLoais(id);

        if (!theLoai.getTenTheLoai().equalsIgnoreCase(request.getTenTheLoai())
                && theLoaiRepository.existsByTenTheLoaiIgnoreCase(request.getTenTheLoai())) {
            throw new DuplicateResourceException("Tên thể loại đã tồn tại");
        }

        theLoai.setTenTheLoai(request.getTenTheLoai());
        return theLoaiRepository.save(theLoai);
    }

    public void deleteTheLoai(Integer id) {
        if (!theLoaiRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy thể loại để xoá, mã: " + id);
        }
        theLoaiRepository.deleteById(id);
    }
}
