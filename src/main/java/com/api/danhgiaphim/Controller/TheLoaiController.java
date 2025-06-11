package com.api.danhgiaphim.Controller;

import com.api.danhgiaphim.dto.request.TheLoaiRequest;
import com.api.danhgiaphim.entity.TheLoai;
import com.api.danhgiaphim.service.TheLoaiService;
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
@RequestMapping("/theloais")
public class TheLoaiController {

    @Autowired
    private TheLoaiService theLoaiService;

    @PostMapping
    public TheLoai createTheLoai(@RequestBody TheLoaiRequest request) {
        return theLoaiService.createTheLoai(request);
    }

    @GetMapping
    public List<TheLoai> selectTheLoai() {
        return theLoaiService.getTheLoais();
    }

    @GetMapping("/{maTheLoai}")
    public TheLoai selectTheLoaiById(@PathVariable("maTheLoai") Integer maTheLoai) {
        return theLoaiService.getTheLoais(maTheLoai);
    }

    @PutMapping("/{maTheLoai}")
    public TheLoai updateTheLoai(@PathVariable("maTheLoai") Integer maTheLoai, @RequestBody TheLoaiRequest request) {
        return theLoaiService.updateTheLoai(maTheLoai, request);
    }

    @DeleteMapping("/{maTheLoai}")
    public String deleteTheLoai(@PathVariable("maTheLoai") Integer maTheLoai) {
        theLoaiService.deleteTheLoai(maTheLoai);
        return "Xoá Thành Công";
    }
}
