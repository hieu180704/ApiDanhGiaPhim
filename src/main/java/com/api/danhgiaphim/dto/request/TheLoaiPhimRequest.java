package com.api.danhgiaphim.dto.request;

public class TheLoaiPhimRequest {

    private String maPhim;
    private Integer maTheLoai;

    // Getters và Setters
    public String getMaPhim() { return maPhim; }
    public void setMaPhim(String maPhim) { this.maPhim = maPhim; }

    public Integer getMaTheLoai() { return maTheLoai; }
    public void setMaTheLoai(Integer maTheLoai) { this.maTheLoai = maTheLoai; }
}