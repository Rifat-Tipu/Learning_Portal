package com.example.LearningPortal.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InstructorDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;
    @Email(message = "Email is not valid")
    @NotBlank(message = "Email is required")
    @Size(min = 5, max = 50)
    private String email;
    @NotBlank(message = "Specialization is required")
    @Size(min = 3, max = 50)
    private String specialization;
    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 15)
    private String password;

}
