package com.example.servingwebcontent.repositories;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.example.servingwebcontent.model.Product; // Đã sửa: Model -> model
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> { 

    List<Product> findByCategory_Id(Long categoryId); 
    List<Product> findByNameContainingIgnoreCase(String keyword);
}