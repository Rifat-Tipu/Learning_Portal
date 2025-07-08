package com.example.LearningPortal.service;

import com.example.LearningPortal.DTO.CourseDTO;
import com.example.LearningPortal.entity.Course;
import com.example.LearningPortal.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public void addCourse(CourseDTO courseDTO) {
        Course course=new Course();
        course.setTitle(courseDTO.getTitle());
        course.setDescription(courseDTO.getDescription());
        course.setPrice(courseDTO.getPrice());
        courseRepository.save(course);
    }

    public List<CourseDTO> getCourseDetails() {
        List<Course>courses=courseRepository.findAll();
        return courses.stream().map(course -> {
            CourseDTO dto=new CourseDTO();
            dto.setTitle(course.getTitle());
            dto.setDescription(course.getDescription());
            dto.setPrice(course.getPrice());
            return dto;
        }).toList();
    }

    public void updateCourse(int id, CourseDTO updateCourse) {
       Course course=courseRepository.findById(id).orElseThrow(()->new RuntimeException("Course not found"));
       course.setTitle(updateCourse.getTitle());
       course.setDescription(updateCourse.getDescription());
       course.setPrice(updateCourse.getPrice());
       courseRepository.save(course);

}

    public void deleteCourse(int id) {

        courseRepository.deleteById(id);
    }
    }
