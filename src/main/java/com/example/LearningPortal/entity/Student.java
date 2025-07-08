package com.example.LearningPortal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"id", "name", "email", "password", "address", "phone_no"})
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length=50)
    private String name;
    @Column(length=50)
    private String email;
    @Column(length=15)
    private String password;
    @Column(length=80)
    private String Address;
    @Column(length=15)
    private String phone_no;
    @ManyToMany(cascade = CascadeType.PERSIST)
            @JoinTable(
                    name="student_course",
                    joinColumns = @JoinColumn(name = "student_id"),
                    inverseJoinColumns = @JoinColumn(name = "course_id")
            )
            @JsonBackReference
    List<Course>courseList;

    @OneToMany(mappedBy = "student")
            @JsonManagedReference
    List<Payment>paymentList;

    @OneToMany(mappedBy = "student")
            @JsonManagedReference
   List<Review>reviewList;


}
