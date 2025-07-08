package com.example.LearningPortal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 80)
    private String comment;
    private int rating;

    @ManyToOne
    @JoinColumn(name = "Admin_ID")
    @JsonBackReference
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "Course_id")
            @JsonBackReference
    Course course;

    @ManyToOne
    @JoinColumn(name = "Student_id")
            @JsonBackReference
    Student student;
}
