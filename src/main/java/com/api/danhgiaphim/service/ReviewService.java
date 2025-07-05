package com.api.danhgiaphim.service;

import com.api.danhgiaphim.dto.request.ReviewRequest;
import com.api.danhgiaphim.entity.*;
import com.api.danhgiaphim.exception.DuplicateResourceException;
import com.api.danhgiaphim.repository.*;
import java.time.LocalDate;
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

    @Autowired
    private PhimService phimService;

    public Review createReview(ReviewRequest request) {

        if (reviewRepository.existsByPhim_MaPhimAndTaiKhoan_Id(request.getMaPhim(), request.getMaTaiKhoan())) {
            throw new DuplicateResourceException("Tài khoản này đã đánh giá phim này.");
        }

        Phim phim = phimRepository.findById(request.getMaPhim())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phim với mã: " + request.getMaPhim()));

        User user = usersRepository.findById(request.getMaTaiKhoan())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tài khoản với mã: " + request.getMaTaiKhoan()));

        Review review = new Review();
        review.setPhim(phim);
        review.setTaiKhoan(user);
        review.setRating(request.getRating());
        review.setComment(request.getComment());
        review.setNgayReview(request.getNgayReview() != null ? request.getNgayReview() : LocalDate.now());

        Review savedReview = reviewRepository.save(review);
        phimService.updateOverallRating(savedReview.getPhim().getMaPhim());

        return savedReview;
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

        Review updatedReview = reviewRepository.save(review);
        phimService.updateOverallRating(updatedReview.getPhim().getMaPhim());

        return updatedReview;
    }

    public void deleteReview(Integer id) {
        Review reviewToDelete = getReviewById(id);
        Integer phimId = reviewToDelete.getPhim().getMaPhim();
        
        if (!reviewRepository.existsById(id)) {
            throw new RuntimeException("Không tìm đánh giá để xoá");
        }
        reviewRepository.deleteById(id);
        phimService.updateOverallRating(phimId);
    }

}
