package com.api.danhgiaphim.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DienVien_Phim")
public class DienVienPhim {

    @EmbeddedId
    private DienVienPhimId id;

    @ManyToOne
    @MapsId("maDienVien")
    @JoinColumn(name = "maDienVien")
    private DienVien dienVien;

    @ManyToOne
    @MapsId("maPhim")
    @JoinColumn(name = "maPhim")
    private Phim phim;

    // Getters và Setters
    public DienVienPhimId getId() { return id; }
    public void setId(DienVienPhimId id) { this.id = id; }

    public DienVien getDienVien() { return dienVien; }
    public void setDienVien(DienVien dienVien) { this.dienVien = dienVien; }

    public Phim getPhim() { return phim; }
    public void setPhim(Phim phim) { this.phim = phim; }
}