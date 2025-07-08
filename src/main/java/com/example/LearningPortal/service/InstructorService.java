package com.example.LearningPortal.service;

import com.example.LearningPortal.DTO.AdminDTO;
import com.example.LearningPortal.DTO.InstructorDTO;
import com.example.LearningPortal.entity.Instructor;
import com.example.LearningPortal.repository.InstructorRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService {
    private final InstructorRepository instructorRepository;


    public void addInstructor(@Valid InstructorDTO instructorDTO) {
        Instructor instructor=new Instructor();
        instructor.setName(instructorDTO.getName());
        instructor.setEmail(instructorDTO.getEmail());
        instructor.setSpecialization(instructorDTO.getSpecialization());
        instructor.setPassword(instructorDTO.getPassword());
        instructorRepository.save(instructor);
    }


    public List<InstructorDTO> getInstructorDetails() {
        List<Instructor>instructors=instructorRepository.findAll();
        return instructors.stream().map(instructor -> {
            InstructorDTO dto=new InstructorDTO();
            dto.setName(instructor.getName());
            dto.setEmail(instructor.getEmail());
            dto.setSpecialization(instructor.getSpecialization());
            return dto;
        }).toList();
    }

    public void updateInstructor(int id, InstructorDTO instructorDTO) {
        Instructor instructor=instructorRepository.findById(id).orElseThrow(()->new RuntimeException("Instructor not found"));
        instructor.setName(instructorDTO.getName());
        instructor.setEmail(instructorDTO.getEmail());
        instructor.setSpecialization(instructorDTO.getSpecialization());
        instructor.setPassword(instructorDTO.getPassword());
        instructorRepository.save(instructor);
    }

    public void deleteInstructor(int id, InstructorDTO instructorDTO) {
        Instructor instructor=instructorRepository.findById(id).orElseThrow(()->new RuntimeException("Instructor not found"));
        instructorRepository.deleteById(instructor.getId());
    }
}
