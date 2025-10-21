package com.example.services;
import com.example.servingwebcontent.entities.Product;
import com.example.servingwebcontent.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Lấy tất cả sản phẩm
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Lấy sản phẩm theo ID
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    // Lưu (thêm mới hoặc cập nhật) sản phẩm
    public Product save(Product product) {
        return productRepository.save(product);
    }

    // Xóa sản phẩm theo ID
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    // --- CÁC PHƯƠNG THỨC LOGIC MỚI ---

    /**
     * Tìm tất cả sản phẩm thuộc về một danh mục cụ thể.
     * @param categoryId ID của danh mục cần tìm.
     * @return Danh sách các sản phẩm thuộc danh mục đó.
     */
    public List<Product> findByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    /**
     * Tìm kiếm sản phẩm theo từ khóa trong tên.
     * @param keyword Từ khóa để tìm kiếm.
     * @return Danh sách các sản phẩm có tên chứa từ khóa.
     */
    public List<Product> searchByName(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }
}

