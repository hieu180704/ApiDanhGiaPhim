package com.api.danhgiaphim.Controller;

import com.api.danhgiaphim.dto.request.ApiResponse;
import com.api.danhgiaphim.dto.request.PhimRequest;
import com.api.danhgiaphim.entity.Phim;
import com.api.danhgiaphim.service.PhimService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/phims")
public class PhimController {

    @Autowired
    private PhimService phimService;

    @PostMapping
    public ResponseEntity<ApiResponse<Phim>> createPhim(@RequestBody @Valid PhimRequest request) {
        Phim phim = phimService.createPhim(request);
        return ResponseEntity.ok(new ApiResponse<>(200, "Tạo phim thành công", phim));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Phim>>> getPhims() {
        List<Phim> ds = phimService.getPhims();
        return ResponseEntity.ok(new ApiResponse<>(200, "Lấy danh sách phim thành công", ds));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Phim>> getPhimById(@PathVariable Integer id) {
        Phim phim = phimService.getPhimById(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "Lấy phim thành công", phim));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Phim>> updatePhim(@PathVariable @Valid Integer id, @RequestBody PhimRequest request) {
        Phim phim = phimService.updatePhim(id, request);
        return ResponseEntity.ok(new ApiResponse<>(200, "Cập nhật phim thành công", phim));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deletePhim(@PathVariable Integer id) {
        phimService.deletePhim(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "Xóa phim thành công", null));
    }
}
