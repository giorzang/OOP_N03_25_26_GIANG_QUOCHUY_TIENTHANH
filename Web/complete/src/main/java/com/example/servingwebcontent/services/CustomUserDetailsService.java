package com.example.servingwebcontent.services;

import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.model.Role; // Cần import nếu chưa có
import com.example.servingwebcontent.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy người dùng với email: " + email));

        // BẮT LỖI: Kiểm tra Role (quyền hạn) có bị NULL không.
        // Đây là nguyên nhân có thể gây ra NullPointerException, dẫn đến lỗi đăng nhập.
        if (user.getRole() == null) {
            // Nếu Role là NULL, từ chối xác thực để tránh lỗi không mong muốn
            throw new UsernameNotFoundException("Người dùng " + email + " không có Role hợp lệ.");
        }

        // Chuyển Role thành GrantedAuthority
        List<GrantedAuthority> authorities = Collections.singletonList(
                new SimpleGrantedAuthority(user.getRole().name())
        );

        // Trả về đối tượng UserDetails
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }
}