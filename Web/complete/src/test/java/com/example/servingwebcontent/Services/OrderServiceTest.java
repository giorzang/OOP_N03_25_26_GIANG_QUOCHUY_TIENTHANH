package com.example.servingwebcontent.services; // SỬA: Services -> services

import com.example.servingwebcontent.model.CartItem; // SỬA: Model -> model
import com.example.servingwebcontent.model.Product; // SỬA: Model -> model
import com.example.servingwebcontent.model.User;    // SỬA: Model -> model
import com.example.servingwebcontent.model.Order;   // SỬA: Model -> model
import com.example.servingwebcontent.repositories.OrderRepository; // SỬA: Repositories -> repositories
import com.example.servingwebcontent.repositories.ProductRepository; // SỬA: Repositories -> repositories
import com.example.servingwebcontent.repositories.UserRepository; // SỬA: Repositories -> repositories
import com.example.servingwebcontent.exception.InsufficientStockException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal; // BỔ SUNG: Cần import BigDecimal
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
// SỬA: Tên class OrderServiceTest phải nằm trong package services
public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private OrderRepository orderRepository;

    private User testUser;
    private Product product1;
    private Product product2;
    private List<CartItem> validCart;
    private List<CartItem> insufficientStockCart;

    @BeforeEach
    void setUp() {
        testUser = new User();
        testUser.setId(1L);
        testUser.setEmail("test@user.com");

        product1 = new Product();
        product1.setId(10L);
        product1.setName("Cà rốt hữu cơ");
        product1.setStock(20);
        // SỬA LỖI KIỂU DỮ LIỆU: Double/int -> BigDecimal
        product1.setPrice(BigDecimal.valueOf(30000.0));

        product2 = new Product();
        product2.setId(20L);
        product2.setName("Rau cải tươi");
        product2.setStock(5);
        // SỬA LỖI KIỂU DỮ LIỆU: Double/int -> BigDecimal
        product2.setPrice(BigDecimal.valueOf(25000.0));

        validCart = Arrays.asList(
                // SỬA LỖI KIỂU DỮ LIỆU: long -> BigDecimal cho giá
                new CartItem(10L, "Cà rốt hữu cơ", BigDecimal.valueOf(30000.0), 2)
        );

        insufficientStockCart = Arrays.asList(
                // SỬA LỖI KIỂU DỮ LIỆU: long -> BigDecimal cho giá
                new CartItem(20L, "Rau cải tươi", BigDecimal.valueOf(25000.0), 10)
        );
    }

    /** ✅ Hàm tiện ích: chuyển List<CartItem> thành Map<Long, Integer> */
    private Map<Long, Integer> convertCartToMap(List<CartItem> cartItems) {
        Map<Long, Integer> map = new HashMap<>();
        for (CartItem item : cartItems) {
            map.put(item.getProductId(), item.getQuantity());
        }
        return map;
    }

    @Test
    void testCreateOrder_Success() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        when(productRepository.findById(10L)).thenReturn(Optional.of(product1));

        assertDoesNotThrow(() -> 
            orderService.createOrder(1L, convertCartToMap(validCart), "123 Đường Test")
        );

        verify(productRepository, times(1)).save(argThat(
                p -> p.getId().equals(10L) && p.getStock() == 18
        ));

        verify(orderRepository, times(1)).save(any(Order.class));
    }

    @Test
    void testCreateOrder_InsufficientStock_ThrowsException() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        when(productRepository.findById(20L)).thenReturn(Optional.of(product2));

        InsufficientStockException exception = assertThrows(
                InsufficientStockException.class,
                () -> orderService.createOrder(1L, convertCartToMap(insufficientStockCart), "Địa chỉ test")
        );

        assertTrue(exception.getMessage().contains("Rau cải tươi"));

        verify(productRepository, never()).save(any(Product.class));
        verify(orderRepository, never()).save(any(Order.class));
    }

    @Test
    void testCreateOrder_UserNotFound_ThrowsException() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(
                // Lưu ý: OrderService của bạn dùng ResourceNotFoundException nhưng catch là RuntimeException cũng chấp nhận
                RuntimeException.class, 
                () -> orderService.createOrder(99L, convertCartToMap(validCart), "Địa chỉ test")
        );

        verify(orderRepository, never()).save(any(Order.class));
    }
}