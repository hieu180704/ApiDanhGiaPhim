package com.api.danhgiaphim.service;

import com.api.danhgiaphim.dto.request.QuocGiaCreationRequest;
import com.api.danhgiaphim.entity.QuocGiaEntity;
import com.api.danhgiaphim.repository.QuocGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuocGiaService {
    @Autowired
    private QuocGiaRepository quocGiaRepository;
    
    public QuocGiaEntity createQuocGia(QuocGiaCreationRequest request){
        QuocGiaEntity quocGiaEntity = new QuocGiaEntity();
        quocGiaEntity.setTenQuocGia(request.getTenQuocGia());
        
        return quocGiaRepository.save(quocGiaEntity);
    }
}
