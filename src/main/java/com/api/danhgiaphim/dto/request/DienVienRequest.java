package com.api.danhgiaphim.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class DienVienRequest {

    @NotBlank(message = "Tên diễn viên không được để trống")
    @Size(max = 50, message = "Tên diễn viên không được vượt quá 50 ký tự")
    @Pattern(regexp = "^[^\\d]*$", message = "Tên diễn viên không được chứa số")
    private String tenDienVien;

    private String anhDienVien;

    @NotNull(message = "Ngày sinh không được để trống")
    @Past(message = "Ngày sinh phải là ngày trong quá khứ")
    private LocalDate ngaySinh;

    @NotNull(message = "Mã quốc gia không được để trống")
    private Integer maQuocGia;

    // Getters và Setters
    public String getAnhDienVien() {
        return anhDienVien;
    }

    public void setAnhDienVien(String anhDienVien) {
        this.anhDienVien = anhDienVien;
    }

    public String getTenDienVien() {
        return tenDienVien;
    }

    public void setTenDienVien(String tenDienVien) {
        this.tenDienVien = tenDienVien;
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
