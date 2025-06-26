package com.api.danhgiaphim.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TheLoaiPhimId implements Serializable {

    @Column(name = "maPhim")
    private String maPhim;

    @Column(name = "maTheLoai")
    private Integer maTheLoai;

    // Default constructor
    public TheLoaiPhimId() {}

    public TheLoaiPhimId(String maPhim, Integer maTheLoai) {
        this.maPhim = maPhim;
        this.maTheLoai = maTheLoai;
    }

    // Equals và HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TheLoaiPhimId that = (TheLoaiPhimId) o;
        return Objects.equals(maPhim, that.maPhim) &&
                Objects.equals(maTheLoai, that.maTheLoai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maPhim, maTheLoai);
    }

    // Getters và Setters
    public String getMaPhim() { return maPhim; }
    public void setMaPhim(String maPhim) { this.maPhim = maPhim; }

    public Integer getMaTheLoai() { return maTheLoai; }
    public void setMaTheLoai(Integer maTheLoai) { this.maTheLoai = maTheLoai; }

    private static final long serialVersionUID = 1L;
}