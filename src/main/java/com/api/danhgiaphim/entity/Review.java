package com.api.danhgiaphim.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maReview;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_phim", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Phim phim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_tai_khoan", referencedColumnName = "id", nullable = false) // chú ý: Users dùng id
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User taiKhoan;

    private Double rating;

    private String comment;

    private LocalDate ngayReview;

    // Getters & Setters
    public Integer getMaReview() {
        return maReview;
    }

    public void setMaReview(Integer maReview) {
        this.maReview = maReview;
    }

    public Phim getPhim() {
        return phim;
    }

    public void setPhim(Phim phim) {
        this.phim = phim;
    }

    public User getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(User taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getNgayReview() {
        return ngayReview;
    }

    public void setNgayReview(LocalDate ngayReview) {
        this.ngayReview = ngayReview;
    }
}
