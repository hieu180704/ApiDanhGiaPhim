package com.api.danhgiaphim.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class PhimRequest {

    @NotBlank(message = "Tiêu đề phim không được để trống")
    private String tieuDe;
    private String poster;

    @NotNull(message = "Thời lượng không được để trống")
    @Min(value = 1, message = "Thời lượng phải lớn hơn 0")
    private Integer thoiLuong;

    @NotNull(message = "Ngày phát hành không được để trống")
    private LocalDate ngayPhatHanh;

    @Size(max = 1000, message = "Mô tả không được quá 1000 ký tự")
    private String moTa;

    @NotNull(message = "Phim phải có đạo diễn")
    private Integer maDaoDien; // giữ nguyên là ID để truyền vào dễ dàng
    
    @NotEmpty(message = "Phim phải có ít nhất 1 thể loại")
    private List<Integer> maTheLoaiList;
    
    @NotEmpty(message = "Phim phải có ít nhất 1 diễn viên")
    private List<Integer> maDienVienList;

    // Getters & Setters
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
    
    public Integer getMaDaoDien() {
        return maDaoDien;
    }

    public void setMaDaoDien(Integer maDaoDien) {
        this.maDaoDien = maDaoDien;
    }

    public List<Integer> getMaTheLoaiList() {
        return maTheLoaiList;
    }

    public void setMaTheLoaiList(List<Integer> maTheLoaiList) {
        this.maTheLoaiList = maTheLoaiList;
    }

    public List<Integer> getMaDienVienList() {
        return maDienVienList;
    }

    public void setMaDienVienList(List<Integer> maDienVienList) {
        this.maDienVienList = maDienVienList;
    }

}
