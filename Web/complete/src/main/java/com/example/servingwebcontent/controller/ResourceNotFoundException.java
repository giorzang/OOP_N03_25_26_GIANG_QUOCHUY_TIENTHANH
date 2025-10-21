package com.example.servingwebcontent.controller;

// Lớp ngoại lệ tùy chỉnh khi không tìm thấy tài nguyên (ví dụ: Product, Category, User, ...)
public class ResourceNotFoundException extends RuntimeException {

    // Constructor chỉ nhận thông báo lỗi
    public ResourceNotFoundException(String message) {
        super(message);
    }

    // Constructor nhận thông báo lỗi và nguyên nhân gốc
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
