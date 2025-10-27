package com.example.servingwebcontent.services;

import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.model.Role; // Giữ lại import cho Role Entity
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

        // Kiểm tra Role có tồn tại không (Đảm bảo người dùng có quyền hợp lệ)
        if (user.getRole() == null) {
            throw new UsernameNotFoundException("Người dùng " + email + " không có Role hợp lệ.");
        }

        // Chuyển Role thành GrantedAuthority
        // LỖI ĐÃ SỬA: Thay thế user.getRole().name() bằng user.getRole().getName()
        // vì Role hiện tại là JPA Entity Class, không phải Enum.
        List<GrantedAuthority> authorities = Collections.singletonList(
                new SimpleGrantedAuthority(user.getRole().getName())
        );

        // Trả về đối tượng UserDetails (sử dụng Email làm username)
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }
}