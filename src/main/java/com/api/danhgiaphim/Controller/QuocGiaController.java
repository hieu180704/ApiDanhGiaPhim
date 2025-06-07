package com.api.danhgiaphim.Controller;

import com.api.danhgiaphim.dto.request.QuocGiaCreationRequest;
import com.api.danhgiaphim.entity.QuocGiaEntity;
import com.api.danhgiaphim.service.QuocGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuocGiaController {
    @Autowired
    private QuocGiaService quocGiaService; 
    
    @PostMapping("/quocgia")
    QuocGiaEntity createQuocGia(@RequestBody QuocGiaCreationRequest request){
        return quocGiaService.createQuocGia(request);
    }
}
