package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.User; // Cần import model User
import com.example.servingwebcontent.repositories.UserRepository; // Cần import UserService
import org.springframework.beans.factory.annotation.Autowired; // Cần import Autowired
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute; // Cần import ModelAttribute
import org.springframework.web.bind.annotation.PostMapping; // Cần import PostMapping
import org.springframework.web.bind.annotation.RequestParam;

public class AuthController {
    // =========================================================
    // PHƯƠNG THỨC QUAN TRỌNG: ÁNH XẠ TRANG ĐĂNG NHẬP
    // Phương thức này khắc phục lỗi "No static resource login"
    // =========================================================
    @GetMapping("/login")
    public String login() {
        // Trả về tên của template Thymeleaf ("login"), sẽ tìm src/main/resources/templates/login.html
        return "login"; 
    }
    
    // =========================================================
    // PHƯƠNG THỨC QUAN TRỌNG: ÁNH XẠ TRANG ĐĂNG NHẬP
    // =========================================================
    @GetMapping("/login")
    public String login() {
        return "login"; 
    }

    // =========================================================
    // SỬA ĐỔI: HIỂN THỊ FORM ĐĂNG KÝ (GET)
    // Thêm đối tượng User vào Model để form Thymeleaf có thể binding
    // =========================================================
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        // Cung cấp một đối tượng User rỗng để form có thể liên kết (th:object="${user}")
        model.addAttribute("user", new User());
        return "register"; 
    }

    // =========================================================
    // BỔ SUNG: XỬ LÝ GỬI DỮ LIỆU ĐĂNG KÝ (POST) <-- KHẮC PHỤC LỖI 405
    // =========================================================
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        
        // Trong một ứng dụng thực tế:
        // 1. Bạn cần thêm logic xác thực (validation) ở đây.
        // 2. Bạn cần kiểm tra xem email đã tồn tại hay chưa.
        
        try {
            // Gọi Service để lưu người dùng (Service sẽ mã hóa mật khẩu và gán Role)
            userRepository.save(user); 
        } catch (Exception e) {
            // Xử lý lỗi (ví dụ: email đã tồn tại)
            model.addAttribute("registrationError", "Đăng ký thất bại. Email có thể đã được sử dụng.");
            // Giữ lại đối tượng user để điền lại form
            model.addAttribute("user", user); 
            return "register"; // Quay lại form nếu có lỗi
        }
        
        // Đăng ký thành công, chuyển hướng về trang đăng nhập với thông báo success
        return "redirect:/login?registerSuccess"; 
    }
}
