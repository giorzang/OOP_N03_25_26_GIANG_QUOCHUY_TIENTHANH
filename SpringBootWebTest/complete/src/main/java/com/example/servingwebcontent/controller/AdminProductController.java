package com.example.servingwebcontent.controller;
// SỬA LỖI: Model -> model
import com.example.servingwebcontent.model.Product;
// SỬA LỖI: Services -> services
import com.example.servingwebcontent.services.CategoryService;
import com.example.servingwebcontent.services.ProductService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/products")
public class AdminProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    // Cần phải có CategoryService để đổ danh sách category vào form
    public AdminProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    /**
     * Hiển thị danh sách sản phẩm (Admin Read)
     */
    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "admin/product_list"; // Dẫn đến file Thymeleaf
    }

    /**
     * Hiển thị Form Thêm/Sửa sản phẩm (Admin Create/Update Form)
     */
    @GetMapping("/form")
    public String showForm(@RequestParam(required = false) Long id, Model model) {
        Product product;
        if (id != null) {
            // Sửa sản phẩm
            product = productService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        } else {
            // Thêm sản phẩm mới
            product = new Product();
        }
        
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.findAll()); // Load Category cho dropdown
        return "admin/product_form";
    }

    /**
     * Xử lý lưu (Thêm mới hoặc Cập nhật) sản phẩm (Admin Create/Update Save)
     */
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Lưu sản phẩm thành công!");
        return "redirect:/admin/products";
    }

    /**
     * Xóa sản phẩm (Admin Delete)
     */
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        productService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Xóa sản phẩm thành công!");
        return "redirect:/admin/products";
    }
}