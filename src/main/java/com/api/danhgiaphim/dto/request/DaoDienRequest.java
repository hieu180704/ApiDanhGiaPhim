package com.api.danhgiaphim.dto.request;

import com.api.danhgiaphim.entity.QuocGia;
import java.time.LocalDate;

public class DaoDienRequest {
    private String anhDaoDien;
    private String tenDaoDien;
    private LocalDate ngaySinh;
    private QuocGia quocGia;

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

    public QuocGia getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(QuocGia quocGia) {
        this.quocGia = quocGia;
    }
}
