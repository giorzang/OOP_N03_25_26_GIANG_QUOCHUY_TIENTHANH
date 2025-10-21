package com.example.servingwebcontent.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Lớp này xử lý tập trung các ngoại lệ (Exception) của toàn bộ ứng dụng.
 * Đặc biệt quan trọng cho việc bắt lỗi nghiệp vụ như Tồn kho (Tiêu chí 6).
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    // Xử lý lỗi khi sản phẩm không đủ tồn kho (Lỗi nghiệp vụ chính)
    @ExceptionHandler(InsufficientStockException.class)
    public ModelAndView handleInsufficientStock(InsufficientStockException ex) {
        // Trả về trang thanh toán (checkout_view.html)
        ModelAndView mav = new ModelAndView("checkout_view");
        
        // Thêm thông báo lỗi để hiển thị trên giao diện
        mav.addObject("error", ex.getMessage()); 
        
        // Cần thêm lại các dữ liệu giỏ hàng/thông tin người dùng vào mav nếu cần
        return mav;
    }

    // Xử lý lỗi khi không tìm thấy tài nguyên (User, Product, Order)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView handleResourceNotFound(ResourceNotFoundException ex) {
        // Trả về trang lỗi chung
        ModelAndView mav = new ModelAndView("error_page");
        mav.addObject("message", "404 Not Found: " + ex.getMessage());
        return mav;
    }
}