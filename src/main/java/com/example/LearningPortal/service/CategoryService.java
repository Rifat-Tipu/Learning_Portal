package com.example.LearningPortal.service;
import com.example.LearningPortal.entity.Category;
import com.example.LearningPortal.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
private final CategoryRepository categoryRepository;

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public Category getCategory(int id) {
        return categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found"));
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category updateCategory(int id, Category category) {
        Category catg=getCategory(id);
        catg.setName(category.getName());
        return categoryRepository.save(catg);
    }

    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }
}
