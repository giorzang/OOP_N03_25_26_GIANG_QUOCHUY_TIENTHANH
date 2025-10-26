package com.example.servingwebcontent.model;

import jakarta.persistence.*;
import java.math.BigDecimal; // IMPORT MỚI
import java.util.List;

/**
 * Lớp Product này đại diện cho một thực thể (entity) sản phẩm trong cơ sở dữ liệu.
 */
@Entity
@Table(name = "products") 
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255) // BỔ SUNG: Kiểm soát độ dài tên
    private String name;
    
    // SỬA: Dùng BigDecimal thay cho double
    @Column(nullable = false, precision = 10, scale = 2) 
    private BigDecimal price;
    
    @Column(columnDefinition = "TEXT") // BỔ SUNG: Dùng TEXT cho mô tả dài
    private String description;
    
    @Column(length = 500) // BỔ SUNG: Kiểm soát độ dài URL ảnh
    private String imageUrl;

    // Trường này dùng để quản lý số lượng sản phẩm còn lại trong kho.
    @Column(nullable = false) 
    private int stock; 

    // Mối quan hệ nhiều-một, nên là LAZY
    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "category_id")
    private Category category;
    
    // BỔ SUNG: Mối quan hệ One-to-Many với OrderDetail (mappedBy trỏ đến tên trường 'product' trong OrderDetail)
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetail> orderDetails;

    public Product() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // SỬA kiểu dữ liệu trả về
    public BigDecimal getPrice() {
        return price;
    }

    // SỬA kiểu dữ liệu đầu vào
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}