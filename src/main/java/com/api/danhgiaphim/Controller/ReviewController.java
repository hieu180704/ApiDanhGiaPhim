package com.api.danhgiaphim.controller;

import com.api.danhgiaphim.dto.request.ApiResponse;
import com.api.danhgiaphim.dto.request.ReviewRequest;
import com.api.danhgiaphim.entity.Review;
import com.api.danhgiaphim.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Review>>> getAllReviews() {
        List<Review> list = reviewService.getAllReviews();
        return ResponseEntity.ok(new ApiResponse<>(200, "Lấy danh sách đánh giá thành công", list));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Review>> createReview(@Valid @RequestBody ReviewRequest request) {
        Review review = reviewService.createReview(request);
        return ResponseEntity.ok(new ApiResponse<>(200, "Tạo đánh giá thành công", review));
    }

    @GetMapping("/{maReview}")
    public ResponseEntity<ApiResponse<Review>> getReviewById(@PathVariable Integer maReview) {
        Review review = reviewService.getReviewById(maReview);
        return ResponseEntity.ok(new ApiResponse<>(200, "Lấy đánh giá thành công", review));
    }

    @PutMapping("/{maReview}")
    public ResponseEntity<ApiResponse<Review>> updateReview(@PathVariable Integer maReview,
                                                            @Valid @RequestBody ReviewRequest request) {
        Review review = reviewService.updateReview(maReview, request);
        return ResponseEntity.ok(new ApiResponse<>(200, "Cập nhật đánh giá thành công", review));
    }

    @DeleteMapping("/{maReview}")
    public ResponseEntity<ApiResponse<String>> deleteReview(@PathVariable Integer maReview) {
        reviewService.deleteReview(maReview);
        return ResponseEntity.ok(new ApiResponse<>(200, "Xoá đánh giá thành công", "OK"));
    }
}
