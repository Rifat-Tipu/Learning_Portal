package com.example.LearningPortal.repository;


import com.example.LearningPortal.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson,Integer> {
}
