package com.example.servingwebcontent.repositories;

import com.example.servingwebcontent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // DÒNG NÀY ĐÃ GÂY LỖI BIÊN DỊCH VÀ KHỞI TẠO BEAN. ĐÃ XÓA.
    // Optional<User> findByUsername(String username); 
    
    // GIỮ LẠI DÒNG NÀY vì nó được sử dụng trong CustomUserDetailsService để tìm kiếm bằng email
    Optional<User> findByEmail(String email);
    
}