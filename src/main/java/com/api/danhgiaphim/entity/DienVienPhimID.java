package com.api.danhgiaphim.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DienVienPhimId implements Serializable {

    @Column(name = "maDienVien")
    private Integer maDienVien;

    @Column(name = "maPhim")
    private String maPhim;

    // Default constructor
    public DienVienPhimId() {}

    public DienVienPhimId(Integer maDienVien, String maPhim) {
        this.maDienVien = maDienVien;
        this.maPhim = maPhim;
    }

    // Equals và HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DienVienPhimId that = (DienVienPhimId) o;
        return Objects.equals(maDienVien, that.maDienVien) &&
                Objects.equals(maPhim, that.maPhim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maDienVien, maPhim);
    }

    // Getters và Setters
    public Integer getMaDienVien() { return maDienVien; }
    public void setMaDienVien(Integer maDienVien) { this.maDienVien = maDienVien; }

    public String getMaPhim() { return maPhim; }
    public void setMaPhim(String maPhim) { this.maPhim = maPhim; }

    private static final long serialVersionUID = 1L;
}