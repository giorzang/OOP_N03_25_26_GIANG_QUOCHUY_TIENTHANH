package com.example.servingwebcontent.model;

import jakarta.persistence.*;
import java.math.BigDecimal; // IMPORT MỚI

@Entity
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Mối quan hệ ManyToOne, nên là LAZY
    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    // Mối quan hệ ManyToOne, nên là LAZY
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private int quantity;

    // SỬA: Dùng BigDecimal thay cho double
    @Column(nullable = false, precision = 10, scale = 2) 
    private BigDecimal price; // Giá tại thời điểm mua

    // Các hàm khởi tạo
    public OrderDetail() {
    }

    // Phương thức truy xuất và thiết lập
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // SỬA kiểu dữ liệu trả về
    public BigDecimal getPrice() {
        return price;
    }

    // SỬA kiểu dữ liệu đầu vào
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // BỔ SUNG: Phương thức tính tổng tiền cho chi tiết đơn hàng
    public BigDecimal calculateSubtotal() {
        if (this.price == null) {
            return BigDecimal.ZERO;
        }
        // Dùng multiply của BigDecimal
        return this.price.multiply(BigDecimal.valueOf(this.quantity)); 
    }
}