package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    /**
     * Maps the root path "/" and "/greeting" to the "greeting" template.
     * Passes a 'name' attribute to the Thymeleaf template.
     * @param name The name to greet, defaults to "Huy".
     * @param model The model to pass attributes to the view.
     * @return The name of the Thymeleaf template ("greeting").
     */
    @GetMapping({"/", "/greeting"})
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Huy") String name, Model model) {
        // Đã sửa lỗi đánh máy: sử dụng model.addAttribute
        model.addAttribute("name", name);
        
        // Trả về tên của Thymeleaf template (sẽ tìm file src/main/resources/templates/greeting.html)
        return "greeting"; 
    }
}
