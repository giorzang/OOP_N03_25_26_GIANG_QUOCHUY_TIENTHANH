package com.example.servingwebcontent.controller;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.ui.Model;

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
    
    // @GetMapping("/register")
    // public String showRegisterForm(Model model) {
    //     model.addAttribute("user", new User());
    //     return "register";
    // }

    // @PostMapping("/register")
    // public String processRegister(@ModelAttribute User user) {
    //     // Gọi service để lưu user vào DB
    //     UserRepository userRepository;
    //     userRepository.save(user);
    //     return "redirect:/login";
    // }
}
