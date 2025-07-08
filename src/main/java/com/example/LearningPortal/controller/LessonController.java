package com.example.LearningPortal.controller;
import com.example.LearningPortal.entity.Lesson;
import com.example.LearningPortal.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/portal")
public class LessonController {
    private final LessonService lessonService;

    @PostMapping("/lesson/add")
    public ResponseEntity<String> addLesson(@RequestBody Lesson lesson) {
        lessonService.addLesson(lesson);
        return ResponseEntity.ok("Lesson added successfully!");
    }

    @GetMapping("/lesson/get")
    public ResponseEntity<List<Lesson>> getAllLessons() {
        return ResponseEntity.ok(lessonService.getAllLessons());
    }

    @PutMapping("/lesson/update/{id}")
    public ResponseEntity<String> updateLesson(@PathVariable int id, @RequestBody Lesson lesson) {
        lessonService.updateLesson(id, lesson);
        return ResponseEntity.ok("Lesson updated successfully!");
    }

    @DeleteMapping("/lesson/delete/{id}")
    public ResponseEntity<String> deleteLesson(@PathVariable int id) {
        lessonService.deleteLesson(id);
        return ResponseEntity.ok("Lesson deleted successfully!");
    }
}
