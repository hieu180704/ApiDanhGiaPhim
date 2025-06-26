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
public class DaoDien { 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maDaoDien;
    private String anhDaoDien;
    private String tenDaoDien;
    private LocalDate ngaySinh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_quoc_gia", nullable = false, foreignKey = @ForeignKey(name = "fk_daodien_quocgia"))
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private QuocGia quocGia;

    public Integer getMaDaoDien() {
        return maDaoDien;
    }

    public void setMaDaoDien(Integer maDaoDien) {
        this.maDaoDien = maDaoDien;
    }

    public String getAnhDaoDien() {
        return anhDaoDien;
    }

    public void setAnhDaoDien(String anhDaoDien) {
        this.anhDaoDien = anhDaoDien;
    }

    public String getTenDaoDien() {
        return tenDaoDien;
    }

    public void setTenDaoDien(String tenDaoDien) {
        this.tenDaoDien = tenDaoDien;
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