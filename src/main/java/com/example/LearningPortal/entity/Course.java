package com.example.LearningPortal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length=50)
    private String title;
    @Column(length=100)
    private String description;
    private int price;

    @ManyToMany(mappedBy = "courseList")
    @JsonManagedReference
    List<Student>studentList;

    @ManyToOne
        @JoinColumn(name="admin_id")
    @JsonBackReference
    Admin admin;

    @ManyToOne
    @JoinColumn(name="category_id")
            @JsonBackReference
    Category category;

    @ManyToOne
    @JoinColumn(name="instructor_id")
            @JsonBackReference
    Instructor instructor;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    List<Lesson>lessonList;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    List<Review>reviewList;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    List<Payment>paymentList;


}
