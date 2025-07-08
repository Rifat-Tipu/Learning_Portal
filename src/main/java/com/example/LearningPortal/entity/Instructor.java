package com.example.LearningPortal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Instructor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@Column(length=50)
private String name;
@Column(length=50)
private String email;
@Column(length=15)
private String password;
@Column(length=50)
private String specialization;
@Column(length=15)
private String phone_no;

@ManyToOne
        @JoinColumn(name="admin_id")
        @JsonBackReference
Admin admin;

@OneToMany(mappedBy = "instructor")
        @JsonManagedReference
List<Course> courseList;
}
