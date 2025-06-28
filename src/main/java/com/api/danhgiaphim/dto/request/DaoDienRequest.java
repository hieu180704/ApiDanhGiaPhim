package com.api.danhgiaphim.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class DaoDienRequest {

    private String anhDaoDien;

    @NotBlank(message = "Tên đạo diễn không được để trống")
    @Size(max = 50, message = "Tên đạo diễn không được vượt quá 50 ký tự")
    @Pattern(regexp = "^[^\\d]*$", message = "Tên đạo diễn không được chứa số")
    private String tenDaoDien;
    
    @NotNull(message = "Ngày sinh không được để trống")
    @Past(message = "Ngày sinh phải là ngày trong quá khứ")    
    private LocalDate ngaySinh;
    
    @NotNull(message = "Mã quốc gia không được để trống")
    private Integer maQuocGia;

    public String getAnhDaoDien() {
        return anhDaoDien;
    }

    public void setAnhDaoDien(String anhDaoDien) {
        this.anhDaoDien = anhDaoDien;
    }

    public String getTenDaoDien() {
        return tenDaoDien;
    }

    public void setTenDaoDien(String tenDaoDien) {
        this.tenDaoDien = tenDaoDien;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Integer getQuocGiaId() {
        return maQuocGia;
    }

    public void setQuocGiaId(Integer quocGiaId) {
        this.maQuocGia = quocGiaId;
    }

    
}
