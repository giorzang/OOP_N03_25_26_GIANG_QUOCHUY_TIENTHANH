package com.example.servingwebcontent.repositories;

import com.example.servingwebcontent.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
    /**
     * Tìm kiếm một Role dựa trên tên (ví dụ: "USER", "ADMIN").
     * @param name Tên của Role
     * @return Đối tượng Role tương ứng
     */
    Role findByName(String name); 
}