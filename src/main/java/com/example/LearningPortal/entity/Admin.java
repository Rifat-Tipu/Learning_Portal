package com.example.LearningPortal.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length=50)
    private String name;
    @Column(length=50)
    private String email;
    @Column(length=15)
    private String password;
    @Column(length=15)
    private String phone_no;

    // Relation between Admin and Category
@OneToMany(mappedBy = "admin")
@JsonManagedReference
    List<Category>categoryList;
// Relation between Admin and Course
@OneToMany(mappedBy = "admin")
@JsonManagedReference
    List<Course>courseList;

@OneToMany(mappedBy = "admin")
        @JsonManagedReference
List<Review>reviewList;

@OneToMany(mappedBy = "admin")
        @JsonManagedReference
List<Instructor>instructorList;

}
