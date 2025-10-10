package com.example.servingwebcontent.repositories; // Sửa lại cho khớp với thư mục

import com.example.servingwebcontent.entities.Product; // Sửa lại cho khớp với thư mục
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Thêm phương thức để tìm sản phẩm theo Category Id
    List<Product> findByCategoryId(Long categoryId);

    // Thêm phương thức để tìm sản phẩm theo tên (không phân biệt hoa thường)
    List<Product> findByNameContainingIgnoreCase(String keyword);
}

