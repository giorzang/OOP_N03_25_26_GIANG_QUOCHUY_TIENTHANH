package com.example.sellinggreens.service;

import com.example.sellinggreens.model.User;
import com.example.sellinggreens.repository.UserRepository;
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

    /**
     * Phương thức bắt buộc của UserDetailsService để tải thông tin người dùng bằng email (username).
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Tìm User trong CSDL bằng email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy người dùng với email: " + email));

        // Chuyển Role của User thành GrantedAuthority
        List<GrantedAuthority> authorities = Collections.singletonList(
                new SimpleGrantedAuthority(user.getRole().name())
        );

        // Trả về đối tượng UserDetails mà Spring Security sử dụng
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(), // Lưu ý: Mật khẩu PHẢI đã được mã hóa trong CSDL
                authorities
        );
    }
}
