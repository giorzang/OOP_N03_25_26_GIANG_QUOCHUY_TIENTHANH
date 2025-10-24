package com.example.servingwebcontent.Services;

import com.example.servingwebcontent.Model.Category;
import com.example.servingwebcontent.Repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Thêm import này

import java.util.List;
import java.util.Optional;

@Service
@Transactional // Khuyến nghị sử dụng @Transactional cho các lớp Service tương tác với DB
public class CategoryService {

    private final CategoryRepository categoryRepository; // Đổi sang final

    // TIÊM ĐỐI TƯỢNG QUA CONSTRUCTOR
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Lấy tất cả danh mục
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    // Lấy danh mục theo ID
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    // Lưu danh mục (Create/Update)
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    // Xóa danh mục
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
