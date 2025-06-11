package com.api.danhgiaphim.Controller;

import com.api.danhgiaphim.dto.request.QuocGiaCreationRequest;
import com.api.danhgiaphim.entity.QuocGia;
import com.api.danhgiaphim.service.QuocGiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quocgias")
public class QuocGiaController {

    @Autowired
    private QuocGiaService quocGiaService;

    @PostMapping
    QuocGia createQuocGia(@RequestBody QuocGiaCreationRequest request) {
        return quocGiaService.createQuocGia(request);
    }

    @PostMapping("/add")
    public List<QuocGia> addQuocGias(@RequestBody List<QuocGia> QuocGia) {
        return quocGiaService.saveAllQuocGias(QuocGia);
    }

    @GetMapping
    List<QuocGia> getQuocGia() {
        return quocGiaService.getQuocGias();
    }
    
    @GetMapping("/{maQuocGia}")
    QuocGia getQuocGia(@PathVariable("maQuocGia") Integer maQuocGia){
        return quocGiaService.getQuocGia(maQuocGia);
    }
    
    @PutMapping("/{maQuocGia}")
    QuocGia updateQuocGia(@PathVariable("maQuocGia") Integer maQuocGia, @RequestBody QuocGiaCreationRequest request){
        return quocGiaService.updateQuocGia(maQuocGia, request);
    }
    
    @DeleteMapping("/{maQuocGia}")
    String deleteQuocGia(@PathVariable("maQuocGia") Integer maQuocGia){
        quocGiaService.deleteQuocGia(maQuocGia);
        return "Đã Xoá Quốc Gia";
    }
}
