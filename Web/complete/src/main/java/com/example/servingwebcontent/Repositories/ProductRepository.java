package com.example.servingwebcontent.Repositories;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.example.servingwebcontent.Model.Product;       

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> { 

    List<Product> findByCategory_Id(Long categoryId); 
    List<Product> findByNameContainingIgnoreCase(String keyword);
}