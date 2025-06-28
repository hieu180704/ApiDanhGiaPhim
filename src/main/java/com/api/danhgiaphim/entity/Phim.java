package com.api.danhgiaphim.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Phim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maPhim;

    private String tieuDe;
    private String poster;
    private Integer thoiLuong;
    private LocalDate ngayPhatHanh;
    private String moTa;
    private Double overallRating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maDaoDien", referencedColumnName = "maDaoDien", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private DaoDien daoDien;

    @ManyToMany
    @JoinTable(
            name = "phim_dien_vien",
            joinColumns = @JoinColumn(name = "ma_phim"),
            inverseJoinColumns = @JoinColumn(name = "ma_dien_vien")
    )
    @JsonIgnoreProperties("phims") 
    private List<DienVien> dienViens;

    @ManyToMany
    @JoinTable(
            name = "phim_the_loai",
            joinColumns = @JoinColumn(name = "ma_phim"),
            inverseJoinColumns = @JoinColumn(name = "ma_the_loai")
    )
    @JsonIgnoreProperties("phims")   
    private List<TheLoai> theLoais;


    // Getters & Setters
    public Integer getMaPhim() {
        return maPhim;
    }

    public void setMaPhim(Integer maPhim) {
        this.maPhim = maPhim;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Integer getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(Integer thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public LocalDate getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(LocalDate ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Double getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Double overallRating) {
        this.overallRating = overallRating;
    }

    public DaoDien getDaoDien() {
        return daoDien;
    }

    public void setDaoDien(DaoDien daoDien) {
        this.daoDien = daoDien;
    }

    public List<DienVien> getDienViens() {
        return dienViens;
    }

    public void setDienViens(List<DienVien> dienViens) {
        this.dienViens = dienViens;
    }

    public List<TheLoai> getTheLoais() {
        return theLoais;
    }

    public void setTheLoais(List<TheLoai> theLoais) {
        this.theLoais = theLoais;
    }
    
    
}
