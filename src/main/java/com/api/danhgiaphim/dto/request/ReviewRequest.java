package com.api.danhgiaphim.dto.request;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class ReviewRequest {

    @NotNull(message = "Thiếu Mã Phim")
    private Integer maPhim;

    @NotNull(message = "Thiếu Mã Tài Khoản")
    private Integer maTaiKhoan;

    @NotNull(message = "Điểm đánh giá không được để trống")
    @DecimalMin(value = "0.0", inclusive = true, message = "Điểm đánh giá phải từ 0 đến 10")
    @DecimalMax(value = "10.0", inclusive = true, message = "Điểm đánh giá phải từ 0 đến 10")
    private Double rating;

    @Size(max = 500, message = "Bình luận không được vượt quá 500 ký tự")
    private String comment;

    @PastOrPresent(message = "Ngày đánh giá không được vượt quá ngày hiện tại")
    private LocalDate ngayReview;

    // Getters & Setters
    public Integer getMaPhim() {
        return maPhim;
    }

    public void setMaPhim(Integer maPhim) {
        this.maPhim = maPhim;
    }

    public Integer getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(Integer maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
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
