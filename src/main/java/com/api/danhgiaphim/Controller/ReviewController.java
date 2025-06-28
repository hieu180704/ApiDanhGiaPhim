package com.api.danhgiaphim.controller;

import com.api.danhgiaphim.dto.request.ReviewRequest;
import com.api.danhgiaphim.entity.Review;
import com.api.danhgiaphim.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public Review createReview(@RequestBody @Valid ReviewRequest request) {
        return reviewService.createReview(request);
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Integer id) {
        return reviewService.getReviewById(id);
    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable @Valid Integer id, @RequestBody ReviewRequest request) {
        return reviewService.updateReview(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Integer id) {
        reviewService.deleteReview(id);
        return "Xoá review thành công";
    }
}
