package com.example.servingwebcontent.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.servingwebcontent.Model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
