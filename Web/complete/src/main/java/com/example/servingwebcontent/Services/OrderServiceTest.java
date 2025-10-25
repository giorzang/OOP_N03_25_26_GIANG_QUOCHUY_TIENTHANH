package com.example.servingwebcontent.Services;

import com.example.servingwebcontent.Model.CartItem;
import com.example.servingwebcontent.Model.Product;
import com.example.servingwebcontent.Model.User;
import com.example.servingwebcontent.Repositories.OrderRepository;
import com.example.servingwebcontent.Repositories.ProductRepository;
import com.example.servingwebcontent.Repositories.UserRepository;
import com.example.servingwebcontent.exception.InsufficientStockException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Mở rộng với MockitoExtension để cho phép sử dụng @Mock và @InjectMocks
@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    // Đối tượng Service cần được kiểm thử
    // @InjectMocks sẽ tự động chèn các @Mock bên dưới vào đây
    @InjectMocks
    private OrderService orderService;

    // Các Repository (thành phần phụ thuộc) sẽ được giả lập (mock)
    @Mock
    private ProductRepository productRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private OrderRepository orderRepository; // Cần thiết để lưu Order

    private User testUser;
    private Product product1;
    private Product product2;
    private List<CartItem> validCart;
    private List<CartItem> insufficientStockCart;

    // Khởi tạo dữ liệu mẫu trước mỗi lần chạy test
    @BeforeEach
    void setUp() {
        // 1. Dữ liệu User mẫu
        testUser = new User();
        testUser.setId(1L);
        testUser.setEmail("test@user.com");

        // 2. Dữ liệu Product 1: Tồn kho đủ
        product1 = new Product();
        product1.setId(10L);
        product1.setName("Cà rốt hữu cơ");
        product1.setStock(20);

        // 3. Dữ liệu Product 2: Tồn kho ít
        product2 = new Product();
        product2.setId(20L);
        product2.setName("Rau cải tươi");
        product2.setStock(5);

        // 4. Giỏ hàng hợp lệ (sẽ đặt 2 cà rốt)
        validCart = Arrays.asList(
                new CartItem(10L, "Cà rốt hữu cơ", 30000L, 2)
        );

        // 5. Giỏ hàng vượt quá tồn kho (yêu cầu 10 cải tươi, trong khi chỉ có 5)
        insufficientStockCart = Arrays.asList(
                new CartItem(20L, "Rau cải tươi", 25000L, 10)
        );
    }

    /**
     * Test Case 1: Đặt hàng thành công
     * Mục tiêu: Kiểm tra OrderService có thực hiện đúng 3 bước:
     * 1. Tìm User và Product.
     * 2. Giảm tồn kho (stock).
     * 3. Lưu Order và OrderDetails.
     */
    @Test
    void testPlaceOrder_Success() {
        // Thiết lập hành vi giả lập cho Repository
        // Giả lập tìm thấy User
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        // Giả lập tìm thấy Product
        when(productRepository.findById(10L)).thenReturn(Optional.of(product1));
        
        // Khi gọi placeOrder, KHÔNG được ném ra ngoại lệ
        assertDoesNotThrow(() -> {
            orderService.placeOrder(validCart, 1L, "123 Đường Test");
        });

        // Xác minh (Verify) các thao tác đã được gọi đúng
        
        // 1. Xác minh Product đã được lưu lại (giảm tồn kho)
        // Số lượng tồn kho sau khi đặt 2 sản phẩm: 20 - 2 = 18
        verify(productRepository, times(1)).save(argThat(
                p -> p.getId().equals(10L) && p.getStock() == 18
        ));
        
        // 2. Xác minh Order đã được lưu vào CSDL
        verify(orderRepository, times(1)).save(any());
    }

    /**
     * Test Case 2: Ném ra lỗi khi TỒN KHO KHÔNG ĐỦ
     * Mục tiêu: Kiểm tra OrderService có ném ra InsufficientStockException
     * khi số lượng đặt hàng > tồn kho hiện tại. (Yêu cầu 6)
     */
    @Test
    void testPlaceOrder_InsufficientStock_ThrowsException() {
        // Thiết lập hành vi giả lập
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        // Giả lập tìm thấy Product 2 (tồn kho 5)
        when(productRepository.findById(20L)).thenReturn(Optional.of(product2));

        // Khi gọi placeOrder với giỏ hàng vượt tồn kho (yêu cầu 10 > 5)
        // PHẢI ném ra InsufficientStockException
        InsufficientStockException exception = assertThrows(
                InsufficientStockException.class,
                () -> orderService.placeOrder(insufficientStockCart, 1L, "Địa chỉ test")
        );

        // Kiểm tra thông báo lỗi có chứa tên sản phẩm
        assertTrue(exception.getMessage().contains("Rau cải tươi"));

        // Xác minh: ProductRepository.save() KHÔNG được gọi
        // Vì transaction phải được rollback khi lỗi xảy ra
        verify(productRepository, never()).save(any());
        
        // Xác minh: OrderRepository.save() KHÔNG được gọi
        verify(orderRepository, never()).save(any());
    }
    
    /**
     * Test Case 3: Ném ra lỗi khi Không tìm thấy User
     */
    @Test
    void testPlaceOrder_UserNotFound_ThrowsException() {
        // Giả lập không tìm thấy User
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        // Kiểm tra xem Service có ném ra RuntimeException (hoặc loại lỗi phù hợp) không
        assertThrows(
                RuntimeException.class,
                () -> orderService.placeOrder(validCart, 99L, "Địa chỉ test")
        );
        
        // Xác minh: KHÔNG có thao tác lưu nào được gọi
        verify(orderRepository, never()).save(any());
    }
}
