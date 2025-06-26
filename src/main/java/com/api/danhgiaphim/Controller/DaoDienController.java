package com.api.danhgiaphim.Controller;

import com.api.danhgiaphim.dto.request.DaoDienRequest;
import com.api.danhgiaphim.entity.DaoDien;
import com.api.danhgiaphim.service.DaoDienService;
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
@RequestMapping("/daodiens")
public class DaoDienController {

    @Autowired
    private DaoDienService daoDienService;

    @GetMapping
    public List<DaoDien> selectDaoDien() {
        return daoDienService.getDaoDiens();
    }

    @PostMapping
    DaoDien createDaoDien(@RequestBody DaoDienRequest request) {
        return daoDienService.createDaoDien(request);
    }

    @GetMapping("/{maDaoDien}")
    DaoDien selectDaoDienById(@PathVariable("maDaoDien") Integer maDaoDien) {
        return daoDienService.getDaoDien(maDaoDien);
    }

    @PutMapping("/{maDaoDien}")
    DaoDien updateDaoDien(@PathVariable("maDaoDien") Integer maDaoDien, @RequestBody DaoDienRequest request) {
        return daoDienService.updateDaoDien(maDaoDien, request);
    }

    @DeleteMapping("/{maDaoDien}")
    String xoaDaoDien(@PathVariable("maDaoDien") Integer maDaoDien) {
        daoDienService.deleteDaoDien(maDaoDien);
        return "Đã Xoá Đạo Diễn";
    }
}
