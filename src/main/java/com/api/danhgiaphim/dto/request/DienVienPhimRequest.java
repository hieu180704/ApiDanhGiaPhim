package com.api.danhgiaphim.dto.request;

public class DienVienPhimRequest {

    private Integer maDienVien;
    private String maPhim;

    // Getters và Setters
    public Integer getMaDienVien() { return maDienVien; }
    public void setMaDienVien(Integer maDienVien) { this.maDienVien = maDienVien; }

    public String getMaPhim() { return maPhim; }
    public void setMaPhim(String maPhim) { this.maPhim = maPhim; }
}