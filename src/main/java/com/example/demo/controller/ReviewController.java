package com.example.demo.controller;

import com.example.demo.entity.Review;
import com.example.demo.service.ReviewService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews/{shoeNum}")
    public String getReviews(@PathVariable int shoeNum, HttpSession session, Model model) {
        List<Review> reviews = reviewService.getReviewsByShoeNum(shoeNum);
        model.addAttribute("reviews", reviews);
        model.addAttribute("shoeNum", shoeNum);
        model.addAttribute("loggedInUser", session.getAttribute("loggedInUser"));
        return "reviews";  // This should match the template name reviews.html
    }

    @PostMapping("/reviews/{shoeNum}")
    public String addReview(@PathVariable int shoeNum,
                            @RequestParam String reviewText,
                            HttpSession session,
                            Model model) {
        String username = (String) session.getAttribute("loggedInUser");
        if (username == null) {
            return "redirect:/login";
        }

        reviewService.addReview(shoeNum, username, reviewText);
        return "redirect:/reviews/" + shoeNum;
    }
}
