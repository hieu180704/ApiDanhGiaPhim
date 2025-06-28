package com.api.danhgiaphim.Controller;

import com.api.danhgiaphim.dto.request.ApiResponse;
import com.api.danhgiaphim.dto.request.QuocGiaRequest;
import com.api.danhgiaphim.entity.QuocGia;
import com.api.danhgiaphim.service.QuocGiaService;
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
@RequestMapping("/quocgias")
public class QuocGiaController {

    @Autowired
    private QuocGiaService quocGiaService;

    @PostMapping
    public ResponseEntity<ApiResponse<QuocGia>> createQuocGia(@Valid @RequestBody QuocGiaRequest request) {
        QuocGia created = quocGiaService.createQuocGia(request);
        return ResponseEntity.ok(new ApiResponse<>(200, "Tạo quốc gia thành công", created));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<QuocGia>>> getAllQuocGias() {
        List<QuocGia> list = quocGiaService.getQuocGias();
        return ResponseEntity.ok(new ApiResponse<>(200, "Lấy danh sách quốc gia thành công", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<QuocGia>> getQuocGia(@PathVariable Integer id) {
        QuocGia qg = quocGiaService.getQuocGia(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "Lấy quốc gia thành công", qg));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<QuocGia>> updateQuocGia(@PathVariable Integer id,@Valid @RequestBody QuocGiaRequest request) {
        QuocGia updated = quocGiaService.updateQuocGia(id, request);
        return ResponseEntity.ok(new ApiResponse<>(200, "Cập nhật quốc gia thành công", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteQuocGia(@PathVariable Integer id) {
        quocGiaService.deleteQuocGia(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "Xoá quốc gia thành công", "OK"));
    }
}
