package com.example.servingwebcontent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    // BƯỚC 1: TIÊM (INJECT) CustomUserDetailsService
    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // BƯỚC 2: TẠO DAO AUTHENTICATION PROVIDER
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService); 
        authProvider.setPasswordEncoder(passwordEncoder()); 
        return authProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // THÊM: Cấu hình Spring Security sử dụng Authentication Provider này
            .authenticationProvider(authenticationProvider()) 
            
            // Cấu hình ủy quyền (Authorization)
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/", "/css/**", "/js/**", "/images/**", "/error", "/login", "/register", "/add-to-cart", "/place-order").permitAll()
                // Sử dụng chuỗi "ADMIN" vì Role là Entity
                .requestMatchers("/admin/**").hasAuthority("ADMIN") 
                .anyRequest().authenticated()
            )
            // Cấu hình Form Đăng nhập
            .formLogin(form -> form
                .loginPage("/login") 
                .failureUrl("/login?error") 
                .defaultSuccessUrl("/", true) 
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