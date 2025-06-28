package com.api.danhgiaphim.Controller;

import com.api.danhgiaphim.dto.request.ApiResponse;
import com.api.danhgiaphim.dto.request.TheLoaiRequest;
import com.api.danhgiaphim.entity.TheLoai;
import com.api.danhgiaphim.service.TheLoaiService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<TheLoai>> createTheLoai(@RequestBody @Valid TheLoaiRequest request) {
        TheLoai created = theLoaiService.createTheLoai(request);
        return ResponseEntity.ok(new ApiResponse<>(200, "Tạo thể loại thành công", created));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<TheLoai>>> selectTheLoai() {
        List<TheLoai> data = theLoaiService.getTheLoais();
        return ResponseEntity.ok(new ApiResponse<>(200, "Lấy danh sách thể loại thành công", data));
    }

    @GetMapping("/{maTheLoai}")
    public ResponseEntity<ApiResponse<TheLoai>> selectTheLoaiById(@PathVariable("maTheLoai") Integer maTheLoai) {
        TheLoai result = theLoaiService.getTheLoais(maTheLoai);
        return ResponseEntity.ok(new ApiResponse<>(200, "Lấy thể loại theo ID thành công", result));
    }

    @PutMapping("/{maTheLoai}")
    public ResponseEntity<ApiResponse<TheLoai>> updateTheLoai(@PathVariable("maTheLoai") Integer maTheLoai, @RequestBody @Valid TheLoaiRequest request) {
        TheLoai updated = theLoaiService.updateTheLoai(maTheLoai, request);
        return ResponseEntity.ok(new ApiResponse<>(200, "Cập nhật thể loại thành công", updated));
    }

    @DeleteMapping("/{maTheLoai}")
    public ResponseEntity<ApiResponse<String>> deleteTheLoai(@PathVariable("maTheLoai") Integer maTheLoai) {
        theLoaiService.deleteTheLoai(maTheLoai);
        return ResponseEntity.ok(new ApiResponse<>(200, "Xoá thể loại thành công", "OK"));
    }
}
