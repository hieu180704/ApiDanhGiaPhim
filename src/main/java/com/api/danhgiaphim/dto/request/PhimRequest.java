package com.api.danhgiaphim.dto.request;

import java.time.LocalDate;

public class PhimRequest {

    private String tieuDe;
    private String poster;
    private Integer thoiLuong;
    private LocalDate ngayPhatHanh;
    private String moTa;
    private Integer maDaoDien; 

    // Getters và Setters
    public String getTieuDe() { return tieuDe; }
    public void setTieuDe(String tieuDe) { this.tieuDe = tieuDe; }

    public String getPoster() { return poster; }
    public void setPoster(String poster) { this.poster = poster; }

    public Integer getThoiLuong() { return thoiLuong; }
    public void setThoiLuong(Integer thoiLuong) { this.thoiLuong = thoiLuong; }

    public LocalDate getNgayPhatHanh() { return ngayPhatHanh; }
    public void setNgayPhatHanh(LocalDate ngayPhatHanh) { this.ngayPhatHanh = ngayPhatHanh; }

    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }

    public Integer getMaDaoDien() { return maDaoDien; }
    public void setMaDaoDien(Integer maDaoDien) { this.maDaoDien = maDaoDien; }
}