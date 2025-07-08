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
public class Payment {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

private int amount;
@Column(length=15)
private String date;

@ManyToOne
        @JoinColumn(name="student_id")
        @JsonBackReference
Student student;

@ManyToOne
        @JoinColumn(name="course_id")
        @JsonBackReference
Course course;

}
