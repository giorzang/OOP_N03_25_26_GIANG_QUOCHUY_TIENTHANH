package com.example.servingwebcontent.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Trường Name (Họ và Tên) - Khớp với th:field="*{name}" trong form
    @Column(nullable = false, length = 255)
    private String name; 
    
    // Lưu trữ mật khẩu đã mã hóa
    @Column(nullable = false)
    private String password;

    @Column(length = 500)
    private String address;
    
    // Cột này là ID đăng nhập chính (Username trong Spring Security)
    @Column(unique = true, nullable = false, length = 255) 
    private String email;
    
    @Column(length = 20)
    private String phone;

    // SỬA LỖI: Sử dụng mối quan hệ @ManyToOne với Role Entity
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false) // role_id là khóa ngoại
    private Role role; // Kiểu dữ liệu là Role Entity

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;
    
    // Constructors
    public User() {}

    // Getters and Setters (Đã điều chỉnh tên biến)
    
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getPassword() { return password; }
    public String getAddress() { return address; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public Role getRole() { return role; } 
    public List<Order> getOrders() { return orders; }
    
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPassword(String password) { this.password = password; }
    public void setAddress(String address) { this.address = address; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setRole(Role role) { this.role = role; }
    public void setOrders(List<Order> orders) { this.orders = orders; }
}