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

@Controller
public class HomeController {

    // Tiêm (Inject) UserService để lưu thông tin người dùng mới
    @Autowired
    private UserRepository userRepository; 

    /**
     * Ánh xạ đường dẫn gốc "/" và "/greeting" đến trang chủ "index" (Carousel).
     */
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}