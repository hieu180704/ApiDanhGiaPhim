package com.api.danhgiaphim.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Phim")
public class Phim {

    @Id
    @Column(name = "maPhim")
    private String maPhim;

    @Column(name = "tieuDe")
    private String tieuDe;

    @Column(name = "poster")
    private String poster;

    @Column(name = "thoiLuong")
    private Integer thoiLuong;

    @Column(name = "ngayPhatHanh")
    private LocalDate ngayPhatHanh;

    @Column(name = "moTa")
    private String moTa;

    @Column(name = "overallRating")
    private Float overallRating;

    @Column(name = "soLuotReview")
    private Integer soLuotReview;

    @ManyToOne
    @JoinColumn(name = "maDaoDien", referencedColumnName = "maDaoDien")
    private DaoDien daoDien;

    // Getters và Setters
    public String getMaPhim() { return maPhim; }
    public void setMaPhim(String maPhim) { this.maPhim = maPhim; }

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

    public Float getOverallRating() { return overallRating; }
    public void setOverallRating(Float overallRating) { this.overallRating = overallRating; }

    public Integer getSoLuotReview() { return soLuotReview; }
    public void setSoLuotReview(Integer soLuotReview) { this.soLuotReview = soLuotReview; }

    public DaoDien getDaoDien() { return daoDien; }
    public void setDaoDien(DaoDien daoDien) { this.daoDien = daoDien; }
}