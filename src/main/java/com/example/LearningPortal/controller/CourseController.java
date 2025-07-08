package com.example.LearningPortal.controller;

import com.example.LearningPortal.DTO.CourseDTO;
import com.example.LearningPortal.entity.Course;
import com.example.LearningPortal.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/portal")
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/course/add")
    public ResponseEntity<String>addCourse( @RequestBody CourseDTO courseDTO){
        courseService.addCourse(courseDTO);
        return ResponseEntity.ok("Added Successfully !!");
    }

    @GetMapping("/course/get")
    public ResponseEntity<List<CourseDTO>> getCourseDetails() {
        return ResponseEntity.ok(courseService.getCourseDetails());
    }

    @PutMapping("/course/update/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable int id, @RequestBody CourseDTO courseDTO) {
        courseService.updateCourse(id, courseDTO);
        return ResponseEntity.ok("Updated Successfully !!");
    }
    public ResponseEntity<String> deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course deleted successfully");
    }
}
