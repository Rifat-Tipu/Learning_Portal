package com.example.LearningPortal.service;

import com.example.LearningPortal.DTO.StudentDTO;
import com.example.LearningPortal.entity.Student;
import com.example.LearningPortal.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void addStudent(StudentDTO studentDTO) {
        Student student=new Student();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setPassword(studentDTO.getPassword());
        student.setAddress(studentDTO.getAddress());
        student.setPhone_no(studentDTO.getPhone_no());
        studentRepository.save(student);
    }
    public List<StudentDTO>getAllStudents(){
        List<Student>students=studentRepository.findAll();
        return students.stream().map(student -> {
            StudentDTO dto=new StudentDTO();
            dto.setName(student.getName());
            dto.setEmail(student.getEmail());
            dto.setAddress(student.getAddress());
            dto.setPhone_no(student.getPhone_no());
            return dto;
        }).toList();
    }

    public void updateStudent(int id, StudentDTO student) {
        Student student1=studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student not found"));
        student1.setName(student.getName());
        student1.setEmail(student.getEmail());
        student1.setAddress(student.getAddress());
        student1.setPhone_no(student.getPhone_no());
        studentRepository.save(student1);
    }

    public void deleteStudent(int id) {
        Student student=studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student not found"));
        studentRepository.deleteById(student.getId());
    }
}
