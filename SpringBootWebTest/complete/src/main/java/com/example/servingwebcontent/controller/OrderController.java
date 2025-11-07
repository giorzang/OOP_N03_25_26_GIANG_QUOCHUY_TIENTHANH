package com.example.servingwebcontent.controller; 

// SỬA LỖI: Model -> model
import com.example.servingwebcontent.model.Order;
// SỬA LỖI: Services -> services
import com.example.servingwebcontent.services.OrderService;
import com.example.servingwebcontent.exception.InsufficientStockException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Map;
import java.util.HashMap;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired 
    private OrderService orderService;

    // Hiển thị trang thanh toán
    @GetMapping("/checkout")
    public String showCheckoutPage(Model model) {
        // Trong thực tế, bạn sẽ load dữ liệu giỏ hàng và user vào Model ở đây
        // Ví dụ: model.addAttribute("cartItems", currentCart);
        return "checkout_view";
    }

    // Xử lý yêu cầu đặt hàng (Chức năng lõi)
    @PostMapping("/place")
    public String placeOrder(
        @RequestParam Long userId, 
        @RequestParam String shippingAddress, 
        Model model) {

        // --- GIẢ LẬP GIỎ HÀNG (Cần thay thế bằng logic đọc từ Session/DB thực tế) ---
        Map<Long, Integer> cartItems = new HashMap<>();
        // Giả định bạn có Product ID 1 (3 sản phẩm) và ID 2 (5 sản phẩm)
        cartItems.put(1L, 3); 
        cartItems.put(2L, 5); 
        // --------------------------------------------------------------------------

        try {
            // Gọi dịch vụ để tạo đơn hàng
            Order newOrder = orderService.createOrder(userId, cartItems, shippingAddress);
            // Thành công: Chuyển hướng đến trang cảm ơn
            return "redirect:/order/success?id=" + newOrder.getId();

        } catch (InsufficientStockException e) {
            // Lỗi tồn kho được bắt, thông báo lỗi được gắn vào Model và trả về View
            model.addAttribute("error", e.getMessage());
            // Cần load lại dữ liệu giỏ hàng/thông tin người dùng vào Model nếu muốn hiển thị lại
            return "checkout_view"; 
        }
    }

    // Trang thành công sau khi đặt hàng
    @GetMapping("/success")
    public String showOrderSuccess(@RequestParam Long id, Model model) {
        model.addAttribute("orderId", id);
        return "order_success"; // Tạo file order_success.html
    }
}