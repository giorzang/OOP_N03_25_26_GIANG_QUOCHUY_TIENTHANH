package com.example.servingwebcontent.repositories;

import com.example.servingwebcontent.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Thêm phương thức tìm user bằng username để sau này làm chức năng đăng nhập
    Optional<User> findByUsername(String username);
}
