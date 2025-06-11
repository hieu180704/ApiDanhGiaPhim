package com.api.danhgiaphim.service;

import com.api.danhgiaphim.dto.request.TheLoaiRequest;
import com.api.danhgiaphim.entity.TheLoai;
import com.api.danhgiaphim.repository.TheLoaiRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheLoaiService {
    @Autowired
    private TheLoaiRepository theLoaiRepository;
    
    public TheLoai createTheLoai(TheLoaiRequest request){
        TheLoai theLoai = new TheLoai();
        theLoai.setTenTheLoai(request.getTenTheLoai());
        
        return theLoaiRepository.save(theLoai);
    }
    
    public List<TheLoai> getTheLoais(){
        return theLoaiRepository.findAll();
    }
    
    public TheLoai getTheLoais(Integer id){
        return theLoaiRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy thể loại"));
    }    
    
    public TheLoai updateTheLoai(Integer id,TheLoaiRequest request){
        TheLoai theLoai = getTheLoais(id);
        theLoai.setTenTheLoai(request.getTenTheLoai());
        return theLoaiRepository.save(theLoai);
    }
    
    public void deleteTheLoai(Integer id){
        theLoaiRepository.deleteById(id);
    }
}
