package com.api.danhgiaphim.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class DienVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maDienVien;

    private String anhDienVien;
    private String tenDienVien;
    private LocalDate ngaySinh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_quoc_gia", nullable = false,foreignKey = @ForeignKey(name = "fk_dienvien_quocgia"))
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private QuocGia quocGia;

    public Integer getMaDienVien() {
        return maDienVien;
    }

    public void setMaDienVien(Integer maDienVien) {
        this.maDienVien = maDienVien;
    }

    public String getAnhDienVien() {
        return anhDienVien;
    }

    public void setAnhDienVien(String anhDienVien) {
        this.anhDienVien = anhDienVien;
    }

    public String getTenDienVien() {
        return tenDienVien;
    }

    public void setTenDienVien(String tenDienVien) {
        this.tenDienVien = tenDienVien;
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
