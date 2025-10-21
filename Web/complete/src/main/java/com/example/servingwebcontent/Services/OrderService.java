// src/main/java/.../services/OrderService.java
package com.example.servingwebcontent.services;

import com.example.servingwebcontent.entities.*;
import com.example.servingwebcontent.repositories.*; // Đảm bảo bạn có các Repositories này
import com.example.servingwebcontent.exceptions.*; // Đảm bảo bạn có các Exceptions này
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    @Autowired private OrderRepository orderRepository;
    @Autowired private ProductRepository productRepository;
    @Autowired private UserRepository userRepository;
    
    // ** CRUD: Read - Xem đơn hàng **
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    // ** CHỨC NĂNG LÕI: CREATE ORDER ** (Tiêu chí 5 & 6)
    public Order createOrder(Long userId, Map<Long, Integer> cartItems, String shippingAddress) 
        throws InsufficientStockException {
        
        // 1. Lấy thông tin User
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại: " + userId));
        
        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDate.now().atStartOfDay()); // Dùng LocalDateTime
        order.setStatus("PENDING"); 
        order.setShippingAddress(shippingAddress);
        
        double totalAmount = 0.0;
        List<OrderDetail> details = new ArrayList<>();

        for (Map.Entry<Long, Integer> item : cartItems.entrySet()) {
            Long productId = item.getKey();
            int requestedQuantity = item.getValue();
            
            Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Sản phẩm không tồn tại: " + productId));
            
            // 2. BẮT LỖI TỒN KHO (Tiêu chí 6)
            if (product.getStock() < requestedQuantity) {
                throw new InsufficientStockException("Sản phẩm " + product.getName() + " không đủ hàng. Chỉ còn: " + product.getStock());
            }
            
            // 3. Tạo OrderDetail
            OrderDetail detail = new OrderDetail();
            detail.setOrder(order);
            detail.setProduct(product);
            detail.setQuantity(requestedQuantity);
            detail.setPrice(product.getPrice()); // Lưu giá tại thời điểm mua
            
            totalAmount += requestedQuantity * product.getPrice();
            details.add(detail);

            // 4. Cập nhật giảm tồn kho (CRUD Update Product - Tiêu chí 4)
            product.setStock(product.getStock() - requestedQuantity);
            productRepository.save(product); 
        }

        order.setTotalAmount(totalAmount);
        order.setOrderDetails(details);
        
        // 5. Lưu Order (CRUD Create Order)
        return orderRepository.save(order);
    }
}