package com.api.danhgiaphim.Controller;

import com.api.danhgiaphim.dto.request.ApiResponse;
import com.api.danhgiaphim.dto.request.DaoDienRequest;
import com.api.danhgiaphim.entity.DaoDien;
import com.api.danhgiaphim.service.DaoDienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/daodiens")
public class DaoDienController {

    @Autowired
    private DaoDienService daoDienService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<DaoDien>>> selectDaoDien() {
        return ResponseEntity.ok(
            new ApiResponse<>(200, "Lấy danh sách đạo diễn thành công", daoDienService.getDaoDiens())
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<DaoDien>> createDaoDien(@Valid @RequestBody DaoDienRequest request) {
        DaoDien created = daoDienService.createDaoDien(request);
        return ResponseEntity.ok(new ApiResponse<>(200, "Tạo đạo diễn thành công", created));
    }

    @GetMapping("/{maDaoDien}")
    public ResponseEntity<ApiResponse<DaoDien>> selectDaoDienById(@PathVariable Integer maDaoDien) {
        DaoDien found = daoDienService.getDaoDien(maDaoDien);
        return ResponseEntity.ok(new ApiResponse<>(200, "Lấy đạo diễn thành công", found));
    }

    @PutMapping("/{maDaoDien}")
    public ResponseEntity<ApiResponse<DaoDien>> updateDaoDien(@PathVariable Integer maDaoDien,
                                                              @Valid @RequestBody DaoDienRequest request) {
        DaoDien updated = daoDienService.updateDaoDien(maDaoDien, request);
        return ResponseEntity.ok(new ApiResponse<>(200, "Cập nhật đạo diễn thành công", updated));
    }

    @DeleteMapping("/{maDaoDien}")
    public ResponseEntity<ApiResponse<String>> xoaDaoDien(@PathVariable Integer maDaoDien) {
        daoDienService.deleteDaoDien(maDaoDien);
        return ResponseEntity.ok(new ApiResponse<>(200, "Xoá đạo diễn thành công", "OK"));
    }
}
