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
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@Column(length=50)
private String name;

@OneToMany(mappedBy = "category")
        @JsonManagedReference
List<Course> courseList;

@ManyToOne
        @JoinColumn(name="admin_id")
        @JsonBackReference
Admin admin;
}
