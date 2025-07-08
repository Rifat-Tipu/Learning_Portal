package com.example.LearningPortal.DTO;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ReviewDTO {
    @Size(min = 2, max = 80)
    private String comment;
    private int rating;
}
