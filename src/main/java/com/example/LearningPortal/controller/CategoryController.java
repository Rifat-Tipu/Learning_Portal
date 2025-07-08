package com.example.LearningPortal.controller;

import com.example.LearningPortal.DTO.InstructorDTO;
import com.example.LearningPortal.entity.Category;
import com.example.LearningPortal.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/portal")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/category/add")
    public ResponseEntity<String> addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
        return ResponseEntity.ok("Added Successfully !!");
    }
    @GetMapping("/category/get/all")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/category/get/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable int id) {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }
    @PutMapping("/category/update/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category) {
        return ResponseEntity.ok(categoryService.updateCategory(id, category));
    }

    @DeleteMapping("/category/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully");
    }


}
