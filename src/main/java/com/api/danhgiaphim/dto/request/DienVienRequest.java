package com.api.danhgiaphim.dto.request;

import com.api.danhgiaphim.entity.QuocGia;
import java.time.LocalDate;

public class DienVienRequest {
    private String anhDienVien;
    private String tenDienVien;
    private LocalDate ngaySinh;
    private QuocGia quocGia;

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

    public QuocGia getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(QuocGia quocGia) {
        this.quocGia = quocGia;
    }

    
}
