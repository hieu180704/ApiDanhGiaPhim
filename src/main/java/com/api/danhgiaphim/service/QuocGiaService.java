package com.api.danhgiaphim.service;

import com.api.danhgiaphim.dto.request.QuocGiaCreationRequest;
import com.api.danhgiaphim.entity.QuocGia;
import com.api.danhgiaphim.repository.QuocGiaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuocGiaService {

    @Autowired
    private QuocGiaRepository quocGiaRepository;

    public QuocGia createQuocGia(QuocGiaCreationRequest request) {
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
    
    public QuocGia getQuocGia(Integer id){
        return quocGiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy quốc gia"));
    }
    
    public QuocGia updateQuocGia(Integer id,QuocGiaCreationRequest request){
        QuocGia quocGia = getQuocGia(id);
        quocGia.setTenQuocGia(request.getTenQuocGia());
        
        return quocGiaRepository.save(quocGia);
    }
    
    public void deleteQuocGia(Integer id){
        quocGiaRepository.deleteById(id);
    }
    
}
