package com.example.LearningPortal.repository;

import com.example.LearningPortal.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository <Instructor,Integer>{
}
