package com.example.LearningPortal.service;

import com.example.LearningPortal.DTO.ReviewDTO;
import com.example.LearningPortal.entity.Review;
import com.example.LearningPortal.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public void addReview(ReviewDTO reviewDTO) {
        Review review=new Review();
        review.setComment(reviewDTO.getComment());
        review.setRating(reviewDTO.getRating());
        reviewRepository.save(review);
    }

    public List<ReviewDTO> getAllReviews() {
        List<Review> reviews=reviewRepository.findAll();
        return reviews.stream().map(review -> {
            ReviewDTO dto=new ReviewDTO();
            dto.setComment(review.getComment());
            dto.setRating(review.getRating());
            return dto;
        }).toList();
    }

    public void updateReview(int id, ReviewDTO updatedReview) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with ID: " + id));

        review.setComment(updatedReview.getComment());
        review.setRating(updatedReview.getRating());

        reviewRepository.save(review);
    }

    public void deleteReview(int id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with ID: " + id));
        reviewRepository.delete(review);
    }
}
