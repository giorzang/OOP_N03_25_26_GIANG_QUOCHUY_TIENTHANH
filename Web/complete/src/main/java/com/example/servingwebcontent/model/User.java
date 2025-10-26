package com.example.servingwebcontent.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // SỬA LỖI: Bỏ cột 'username' (không cần thiết) và sử dụng email làm ID đăng nhập.
    // @Column(unique = true, nullable = false, length = 100)
    // private String username; // XÓA DÒNG NÀY HOÀN TOÀN
    
    // Lưu trữ mật khẩu đã mã hóa
    @Column(nullable = false)
    private String password;

    @Column(name = "full_name", length = 255)
    private String fullName;
    
    @Column(length = 500)
    private String address;
    
    // Cột này là ID đăng nhập chính (Username trong Spring Security)
    @Column(unique = true, nullable = false, length = 255) // Đã sửa nullable = false
    private String email;
    
    @Column(length = 20)
    private String phone;

    // Đã xác nhận: @Enumerated(EnumType.STRING) là đúng để khớp với chuỗi "ADMIN" trong DB
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    // ... (Phần OneToMany không thay đổi)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;
    
    // Constructors
    public User() {}

    // Getters and Setters (Đã sửa đổi)
    public Long getId() { return id; }
    // public String getUsername() { return username; } // XÓA HOẶC SỬA METHOD NÀY
    // Giả sử CustomUserDetailsService vẫn sử dụng getEmail().
    
    public String getPassword() { return password; }
    public String getFullName() { return fullName; }
    public String getAddress() { return address; }
    public String getEmail() { return email; } // Dùng Email để tìm User
    public String getPhone() { return phone; }
    public Role getRole() { return role; } // Dùng Role để lấy Authorities

    public void setId(Long id) { this.id = id; }
    // public void setUsername(String username) { this.username = username; } // XÓA METHOD NÀY
    public void setPassword(String password) { this.password = password; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setAddress(String address) { this.address = address; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setRole(Role role) { this.role = role; }

    public List<Order> getOrders() { return orders; }
    public void setOrders(List<Order> orders) { this.orders = orders; }
}