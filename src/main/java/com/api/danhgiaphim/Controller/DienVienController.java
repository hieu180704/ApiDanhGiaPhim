package com.api.danhgiaphim.Controller;

import com.api.danhgiaphim.dto.request.ApiResponse;
import com.api.danhgiaphim.dto.request.DienVienRequest;
import com.api.danhgiaphim.entity.DienVien;
import com.api.danhgiaphim.service.DienVienService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dienviens")
public class DienVienController {

    @Autowired
    private DienVienService dienVienService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<DienVien>>> selectDienVien() {
        return ResponseEntity.ok(
            new ApiResponse<>(200, "Lấy danh sách diễn viên thành công", dienVienService.getDienViens())
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<DienVien>> createDienVien(@Valid @RequestBody DienVienRequest request) {
        DienVien created = dienVienService.createDienVien(request);
        return ResponseEntity.ok(new ApiResponse<>(200, "Tạo diễn viên thành công", created));
    }

    @GetMapping("/{maDienVien}")
    public ResponseEntity<ApiResponse<DienVien>> selectDienVienById(@PathVariable Integer maDienVien) {
        DienVien found = dienVienService.getDienVien(maDienVien);
        return ResponseEntity.ok(new ApiResponse<>(200, "Lấy diễn viên thành công", found));
    }

    @PutMapping("/{maDienVien}")
    public ResponseEntity<ApiResponse<DienVien>> updateDienVien(@PathVariable Integer maDienVien,
                                                                @Valid @RequestBody DienVienRequest request) {
        DienVien updated = dienVienService.updateDienVien(maDienVien, request);
        return ResponseEntity.ok(new ApiResponse<>(200, "Cập nhật diễn viên thành công", updated));
    }

    @DeleteMapping("/{maDienVien}")
    public ResponseEntity<ApiResponse<String>> xoaDienVien(@PathVariable Integer maDienVien) {
        dienVienService.deleteDienVien(maDienVien);
        return ResponseEntity.ok(new ApiResponse<>(200, "Xoá diễn viên thành công", "OK"));
    }
}
