package com.example.demo.service;

import com.example.demo.entity.Review;
import com.example.demo.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    public List<Review> getReviewsByShoeNum(int shoeNum) {
        return reviewMapper.getReviewsByShoeNum(shoeNum);
    }

    public void addReview(int shoeNum, String username, String reviewText) {
        Review review = new Review();
        review.setShoeNum(shoeNum);
        review.setUsername(username);
        review.setReviewText(reviewText);
        review.setReviewDate(LocalDateTime.now());
        reviewMapper.insertReview(review);
    }
}
