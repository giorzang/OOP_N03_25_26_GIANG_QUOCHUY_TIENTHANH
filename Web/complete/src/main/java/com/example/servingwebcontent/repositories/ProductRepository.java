package com.example.servingwebcontent.repositories;

import com.example.servingwebcontent.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Spring Data JPA sẽ tự động cung cấp các phương thức CRUD cơ bản.
    // Chúng ta có thể thêm các phương thức truy vấn tùy chỉnh ở đây sau này.
    // Ví dụ: List<Product> findByNameContaining(String name);
}
