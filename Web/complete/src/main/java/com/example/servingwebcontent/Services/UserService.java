package com.example.servingwebcontent.Services;

import com.example.servingwebcontent.Model.User;
import com.example.servingwebcontent.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Lấy tất cả người dùng
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Tìm người dùng theo ID
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
    
    // Tìm người dùng theo username
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Lưu người dùng
    public User save(User user) {
        // (Sau này có thể thêm logic mã hóa mật khẩu ở đây)
        return userRepository.save(user);
    }

    // Xóa người dùng
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
