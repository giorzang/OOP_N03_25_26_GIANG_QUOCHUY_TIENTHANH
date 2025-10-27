package com.example.servingwebcontent.services;

import com.example.servingwebcontent.model.Role; 
import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.repositories.RoleRepository; // Cần import
import com.example.servingwebcontent.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Cần import
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    // BỔ SUNG: Tiêm BCryptPasswordEncoder
    @Autowired
    private BCryptPasswordEncoder passwordEncoder; 
    
    // BỔ SUNG: Tiêm RoleRepository
    @Autowired
    private RoleRepository roleRepository; 

    // Lấy tất cả người dùng
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Tìm người dùng theo ID
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
    
    // Tìm người dùng theo Email (dùng cho Spring Security)
    public Optional<User> findByEmail(String email) { 
        return userRepository.findByEmail(email); 
    }

    /**
     * LƯU NGƯỜI DÙNG: Mã hóa mật khẩu và gán Role mặc định "USER".
     */
    public User save(User user) {
        
        // 1. MÃ HÓA MẬT KHẨU
        // Lấy mật khẩu thô và mã hóa nó trước khi lưu
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        // 2. GÁN ROLE MẶC ĐỊNH
        // Tìm Role "USER" (Role này phải được tạo sẵn trong DB qua DataLoader)
        Role userRole = roleRepository.findByName("USER"); 
        
        if (userRole == null) {
            // Nếu Role không tồn tại (chưa chạy DataLoader), ném lỗi để người dùng biết
            throw new RuntimeException("Role 'USER' not found in the database. Please run DataLoader.");
        }
        
        user.setRole(userRole);
        
        // 3. LƯU VÀO DATABASE
        return userRepository.save(user);
    }

    // Xóa người dùng
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}