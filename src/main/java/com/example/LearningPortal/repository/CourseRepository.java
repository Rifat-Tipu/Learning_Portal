package com.example.LearningPortal.repository;

import com.example.LearningPortal.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository <Course,Integer>{
}
