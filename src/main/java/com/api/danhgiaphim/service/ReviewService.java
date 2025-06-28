package com.api.danhgiaphim.service;

import com.api.danhgiaphim.dto.request.ReviewRequest;
import com.api.danhgiaphim.entity.*;
import com.api.danhgiaphim.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private PhimRepository phimRepository;

    @Autowired
    private UserRepository usersRepository;

    public Review createReview(ReviewRequest request) {
        Phim phim = phimRepository.findById(request.getMaPhim())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phim"));

        User taiKhoan = usersRepository.findById(request.getMaTaiKhoan())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tài khoản"));

        Review review = new Review();
        review.setPhim(phim);
        review.setTaiKhoan(taiKhoan);
        review.setRating(request.getRating());
        review.setComment(request.getComment());
        review.setNgayReview(request.getNgayReview());

        return reviewRepository.save(review);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(Integer id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy review"));
    }

    public Review updateReview(Integer id, ReviewRequest request) {
        Review review = getReviewById(id);

        Phim phim = phimRepository.findById(request.getMaPhim())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phim"));

        User taiKhoan = usersRepository.findById(request.getMaTaiKhoan())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tài khoản"));

        review.setPhim(phim);
        review.setTaiKhoan(taiKhoan);
        review.setRating(request.getRating());
        review.setComment(request.getComment());
        review.setNgayReview(request.getNgayReview());

        return reviewRepository.save(review);
    }

    public void deleteReview(Integer id) {
        reviewRepository.deleteById(id);
    }
}
