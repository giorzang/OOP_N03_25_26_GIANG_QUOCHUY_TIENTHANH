package com.example.servingwebcontent.services;

import com.example.servingwebcontent.model.Category;
import com.example.servingwebcontent.repositories.CategoryRepository; 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional 
public class CategoryService {

    private final CategoryRepository categoryRepository; 

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true) 
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true) 
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}