package com.example.servingwebcontent.services;

import com.example.servingwebcontent.model.Order;
import com.example.servingwebcontent.model.OrderDetail;
import com.example.servingwebcontent.model.Product;
import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.repositories.OrderRepository;
import com.example.servingwebcontent.repositories.ProductRepository;
import com.example.servingwebcontent.repositories.UserRepository;
import com.example.servingwebcontent.exception.InsufficientStockException;
import com.example.servingwebcontent.exception.ResourceNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // BỔ SUNG: Import @Transactional
import java.time.LocalDateTime; // THAY THẾ: Dùng LocalDateTime thay vì LocalDate
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal; // BẮT BUỘC: Import cho tính toán tiền tệ

@Service
@Transactional // BẮT BUỘC: Đảm bảo tính toàn vẹn dữ liệu cho các thao tác CSDL
public class OrderService {
    
    // KHUYẾN NGHỊ: Dùng Constructor Injection thay cho @Autowired trên Field
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }
    
    // ----------------------------------------------------------------------
    
    // ** CRUD: Read - Xem đơn hàng **
    @Transactional(readOnly = true) // TỐI ƯU: Chỉ định thao tác chỉ đọc
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    // ** CHỨC NĂNG LÕI: CREATE ORDER **
    public Order createOrder(Long userId, Map<Long, Integer> cartItems, String shippingAddress) 
        throws InsufficientStockException {
        
        // 1. Lấy thông tin User
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại: " + userId));
        
        Order order = new Order();
        order.setUser(user);
        
        // SỬA: Dùng LocalDateTime.now() để lấy ngày giờ chính xác
        order.setOrderDate(LocalDateTime.now()); 
        
        order.setStatus("PENDING"); 
        order.setShippingAddress(shippingAddress);
        
        // BẮT BUỘC SỬA: Dùng BigDecimal
        BigDecimal totalAmount = BigDecimal.ZERO;
        List<OrderDetail> details = new ArrayList<>();

        for (Map.Entry<Long, Integer> item : cartItems.entrySet()) {
            Long productId = item.getKey();
            int requestedQuantity = item.getValue();
            
            Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Sản phẩm không tồn tại: " + productId));
            
            // 2. BẮT LỖI TỒN KHO
            if (product.getStock() < requestedQuantity) {
                throw new InsufficientStockException("Sản phẩm " + product.getName() + " không đủ hàng. Chỉ còn: " + product.getStock());
            }
            
            // 3. Tạo OrderDetail
            OrderDetail detail = new OrderDetail();
            detail.setOrder(order);
            detail.setProduct(product);
            detail.setQuantity(requestedQuantity);
            
            // BẮT BUỘC SỬA: Lấy giá sản phẩm (đã là BigDecimal)
            BigDecimal itemPrice = product.getPrice(); 
            detail.setPrice(itemPrice); // Lưu giá tại thời điểm mua
            
            // BẮT BUỘC SỬA: Tính toán tổng tiền bằng phương thức BigDecimal.multiply()
            BigDecimal quantityDecimal = BigDecimal.valueOf(requestedQuantity);
            BigDecimal subtotal = itemPrice.multiply(quantityDecimal);
            
            // Cộng vào tổng tiền bằng phương thức BigDecimal.add()
            totalAmount = totalAmount.add(subtotal);
            
            details.add(detail);

            // 4. Cập nhật giảm tồn kho
            product.setStock(product.getStock() - requestedQuantity);
            productRepository.save(product); 
        }

        // BẮT BUỘC SỬA: Set tổng tiền bằng BigDecimal
        order.setTotalAmount(totalAmount);
        order.setOrderDetails(details);
        
        // 5. Lưu Order
        return orderRepository.save(order);
    }
}