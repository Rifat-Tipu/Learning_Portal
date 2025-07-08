package com.example.LearningPortal.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CourseDTO {
    @NotBlank(message="Title is required")
    @Size(min = 1, max = 50)
    private String title;
    @NotBlank(message="Description is required")
    @Size(min = 1, max = 100)
    private String description;
    @Size(min = 1, max = 50)
    private int price;
}
