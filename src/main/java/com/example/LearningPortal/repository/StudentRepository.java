package com.example.LearningPortal.repository;

import com.example.LearningPortal.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student,Integer>{
}
