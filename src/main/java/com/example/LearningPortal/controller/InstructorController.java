package com.example.LearningPortal.controller;
import com.example.LearningPortal.DTO.AdminDTO;
import com.example.LearningPortal.DTO.InstructorDTO;
import com.example.LearningPortal.entity.Student;
import com.example.LearningPortal.service.InstructorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/portal")
public class InstructorController {
    private final InstructorService instructorService;

    @PostMapping("/instructor/add")
    public ResponseEntity<String> addInstructor(@RequestBody @Valid InstructorDTO instructorDTO){
        instructorService.addInstructor(instructorDTO);
        return ResponseEntity.ok("Added Successfully !!");
    }
    @GetMapping("/instructor/get")
    public ResponseEntity<List<InstructorDTO>>getInstructorDetails(){
        return ResponseEntity.ok(instructorService.getInstructorDetails());
    }
    @PutMapping("/instructor/update/{id}")
    public void updateInstructor(@PathVariable int id, @RequestBody InstructorDTO instructorDTO){
        instructorService.updateInstructor(id,instructorDTO);
    }

    @DeleteMapping("/instructor/delete/{id}")
    public ResponseEntity<String>deleteInstructor(@PathVariable int id,InstructorDTO instructorDTO){
        instructorService.deleteInstructor(id,instructorDTO);
        return ResponseEntity.ok("Deleted Successfully !!");
    }
}
