package com.example.servingwebcontent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.servingwebcontent.model.Category; // Đã sửa: Model -> model
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}