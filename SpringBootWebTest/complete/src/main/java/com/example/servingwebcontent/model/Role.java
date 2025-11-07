package com.example.servingwebcontent.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tên quyền (ví dụ: "CUSTOMER", "ADMIN"). Phải là duy nhất.
    @Column(unique = true, nullable = false)
    private String name; 

    public Role() {
    }

    // Constructor dùng để tạo Role trong DataLoader
    public Role(String name) {
        this.name = name;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}