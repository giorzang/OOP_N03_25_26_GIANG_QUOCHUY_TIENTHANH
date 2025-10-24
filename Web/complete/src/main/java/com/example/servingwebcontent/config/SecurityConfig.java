package com.example.sellinggreens.config;

import com.example.sellinggreens.model.User.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Định nghĩa thuật toán mã hóa mật khẩu.
     * Sử dụng BCrypt để đảm bảo an toàn.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Định nghĩa các quy tắc phân quyền và bảo mật HTTP.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Cấu hình ủy quyền (Authorization)
            .authorizeHttpRequests(authorize -> authorize
                // Cho phép truy cập công khai vào trang chủ, CSS/JS
                .requestMatchers("/", "/css/**", "/js/**", "/images/**", "/add-to-cart", "/place-order", "/error").permitAll()
                
                // Yêu cầu vai trò ADMIN để truy cập /admin
                .requestMatchers("/admin/**").hasAuthority(Role.ADMIN.name())
                
                // Mọi request khác đều yêu cầu xác thực (đăng nhập)
                .anyRequest().authenticated()
            )
            // Cấu hình Form Đăng nhập
            .formLogin(form -> form
                .loginPage("/login") // Tự tạo trang login
                .defaultSuccessUrl("/", true) // Chuyển hướng sau khi đăng nhập thành công
                .permitAll()
            )
            // Cấu hình Đăng xuất
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll()
            );

        return http.build();
    }
}
