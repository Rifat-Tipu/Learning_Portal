package com.example.LearningPortal.controller;

import com.example.LearningPortal.DTO.StudentDTO;
import com.example.LearningPortal.entity.Student;
import com.example.LearningPortal.service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/portal")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/student/add")
    public ResponseEntity<String>addStudent(@RequestBody @Valid StudentDTO studentDTO){
        studentService.addStudent(studentDTO);
        return ResponseEntity.ok("Added Successfully !!");
    }

    @GetMapping("/student/get")
        public ResponseEntity<List<StudentDTO>>getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
        }

        @PutMapping("/student/update/{id}")
        public void updateStudent(@PathVariable int id, @RequestBody StudentDTO studentDTO){
          studentService.updateStudent(id,studentDTO);
        }

        @DeleteMapping("/student/delete/{id}")
        public ResponseEntity<String>deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Deleted Successfully !!");
        }
}
