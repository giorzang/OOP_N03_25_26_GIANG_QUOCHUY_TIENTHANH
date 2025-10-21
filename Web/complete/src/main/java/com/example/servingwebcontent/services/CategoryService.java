package com.example.services;
import com.example.servingwebcontent.entities.Category;
import com.example.servingwebcontent.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Lấy tất cả danh mục
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    // Lấy danh mục theo ID
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    // Lưu danh mục
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    // Xóa danh mục
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
