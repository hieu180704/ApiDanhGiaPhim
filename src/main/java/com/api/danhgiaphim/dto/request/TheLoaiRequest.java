package com.api.danhgiaphim.dto.request;

import jakarta.validation.constraints.NotBlank;

public class TheLoaiRequest {
    @NotBlank(message = "Tên thể loại không được để trống")
    private String tenTheLoai;

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }
    
}
