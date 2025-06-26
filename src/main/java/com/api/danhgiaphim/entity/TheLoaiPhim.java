package com.api.danhgiaphim.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Phim_TheLoai")
public class TheLoaiPhim {

    @EmbeddedId
    private TheLoaiPhimId id;

    @ManyToOne
    @MapsId("maPhim")
    @JoinColumn(name = "maPhim")
    private Phim phim;

    @ManyToOne
    @MapsId("maTheLoai")
    @JoinColumn(name = "maTheLoai")
    private TheLoai theLoai;

    // Getters và Setters
    public TheLoaiPhimId getId() { return id; }
    public void setId(TheLoaiPhimId id) { this.id = id; }

    public Phim getPhim() { return phim; }
    public void setPhim(Phim phim) { this.phim = phim; }

    public TheLoai getTheLoai() { return theLoai; }
    public void setTheLoai(TheLoai theLoai) { this.theLoai = theLoai; }
}