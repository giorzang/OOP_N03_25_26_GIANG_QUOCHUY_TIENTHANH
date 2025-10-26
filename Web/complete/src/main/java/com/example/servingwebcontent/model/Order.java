package com.example.servingwebcontent.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList; // Cần thiết cho helper method
import java.util.List;
import java.math.BigDecimal; // IMPORT MỚI

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FetchType.LAZY được khuyến nghị để tránh tải người dùng không cần thiết
    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "user_id", nullable = false) // Đơn hàng phải thuộc về một người dùng
    private User user;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    // SỬA: Dùng BigDecimal thay cho double để đảm bảo độ chính xác tiền tệ
    @Column(name = "total_amount", nullable = false, precision = 10, scale = 2) // precision và scale cho database
    private BigDecimal totalAmount = BigDecimal.ZERO; 

    // SỬA: Kiểm soát độ dài cột status và đảm bảo không null
    @Column(nullable = false, length = 50) 
    private String status; // Ví dụ: PENDING, COMPLETED, CANCELED

    // Thông tin người nhận hàng
    @Column(name = "shipping_address", length = 500)
    private String shippingAddress;
    
    @Column(name = "shipping_phone", length = 20)
    private String shippingPhone;
    
    // OneToMany thường là LAZY theo mặc định, nhưng ta nên khai báo rõ ràng
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true) 
    private List<OrderDetail> orderDetails = new ArrayList<>(); // Khởi tạo để tránh NullPointerException

    // Constructors
    public Order() {
        this.orderDate = LocalDateTime.now(); // Tự động lấy ngày giờ hiện tại
    }

    // BỔ SUNG: Phương thức helper để quản lý mối quan hệ hai chiều Order <-> OrderDetail
    public void addOrderDetail(OrderDetail detail) {
        orderDetails.add(detail);
        detail.setOrder(this);
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    // SỬA kiểu dữ liệu trả về
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    // SỬA kiểu dữ liệu đầu vào
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getShippingPhone() {
        return shippingPhone;
    }

    public void setShippingPhone(String shippingPhone) {
        this.shippingPhone = shippingPhone;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}