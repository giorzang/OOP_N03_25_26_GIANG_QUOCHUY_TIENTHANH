package com.example.servingwebcontent.repositories; 

import com.example.servingwebcontent.entities.Product; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // CHÍNH XÁC: Phải sử dụng Category_Id vì Category là một Entity liên kết
    // Tên thuộc tính trong Product là 'category' và khóa chính của Category là 'id'
    List<Product> findByCategory_Id(Long categoryId); 

    // CHÍNH XÁC: Phương thức tìm kiếm hoạt động tốt (đã kiểm tra trong ProductService)
    List<Product> findByNameContainingIgnoreCase(String keyword);
}