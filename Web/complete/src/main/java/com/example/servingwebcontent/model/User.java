package com.example.servingwebcontent.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List; // Import cho List

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tên người dùng phải là duy nhất và không được null
    @Column(unique = true, nullable = false, length = 100)
    private String username;

    // Lưu trữ mật khẩu đã mã hóa
    @Column(nullable = false)
    private String password;

    @Column(name = "full_name", length = 255)
    private String fullName;
    
    @Column(length = 500)
    private String address;
    
    // Đặt email là duy nhất (nên làm)
    @Column(unique = true, length = 255)
    private String email;
    
    @Column(length = 20)
    private String phone;

    // BẮT BUỘC: Annotation để lưu enum dưới dạng chuỗi (String)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false) // Đảm bảo role không bị null
    private Role role;

    // BỔ SUNG: Mối quan hệ One-to-Many với Order
    // mappedBy trỏ đến tên trường "user" trong Entity Order
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;
    
    // Constructors
    public User() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public Role getRole() {
        return role;
    } 

    public void setRole(Role role) {
        this.role = role;
    }

    // BỔ SUNG: Getter và Setter cho danh sách đơn hàng
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}