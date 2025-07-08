package com.example.LearningPortal.service;

import com.example.LearningPortal.entity.Lesson;
import com.example.LearningPortal.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;

    public void addLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    public void updateLesson(int id, Lesson updateLesson) {
        Lesson lesson=lessonRepository.findById(id).orElseThrow(()->new RuntimeException("Lesson not found"));
        lesson.setTitle(updateLesson.getTitle());
        lesson.setDuration(updateLesson.getDuration());
        lesson.setCourse(updateLesson.getCourse());
        lessonRepository.save(lesson);
    }

    public void deleteLesson(int id) {
        lessonRepository.deleteById(id);
    }
}
