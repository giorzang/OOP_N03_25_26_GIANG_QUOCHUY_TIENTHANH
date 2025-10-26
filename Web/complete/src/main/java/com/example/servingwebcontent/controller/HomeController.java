package com.example.servingwebcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    /**
     * Ánh xạ đường dẫn gốc "/" và "/greeting" đến trang chủ "index" (Carousel).
     */
    @GetMapping({"/", "/greeting"})
    public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        
        // Thêm thuộc tính 'name' vào Model để Thymeleaf có thể truy cập
        model.addAttribute("name", name);

        // Trả về template "index", sẽ tìm src/main/resources/templates/index.html
        return "index";
    }

    // =========================================================
    // PHƯƠNG THỨC QUAN TRỌNG: ÁNH XẠ TRANG ĐĂNG NHẬP
    // Phương thức này khắc phục lỗi "No static resource login"
    // =========================================================
    @GetMapping("/login")
    public String login() {
        // Trả về tên của template Thymeleaf ("login"), sẽ tìm src/main/resources/templates/login.html
        return "login"; 
    }
}