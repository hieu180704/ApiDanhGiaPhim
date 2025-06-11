package com.api.danhgiaphim.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class QuocGia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maQuocGia;
    private String tenQuocGia;

    public int getMaQuocGia() {
        return maQuocGia;
    }

    public void setMaQuocGia(int maQuocGia) {
        this.maQuocGia = maQuocGia;
    }

    public String getTenQuocGia() {
        return tenQuocGia;
    }

    public void setTenQuocGia(String tenQuocGia) {
        this.tenQuocGia = tenQuocGia;
    }
}
