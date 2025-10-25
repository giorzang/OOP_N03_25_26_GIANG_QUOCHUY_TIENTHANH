package com.example.servingwebcontent.Model; // QUAN TRỌNG: Gói này phải khớp với thư mục của bạn

/**
 * Đây là một POJO (Plain Old Java Object) dùng để đại diện 
 * cho một món hàng trong giỏ hàng (không phải là một Entity lưu trong CSDL).
 */
public class CartItem {

    private Long productId;
    private String name;
    private Long price;
    private int quantity;

    // Constructor rỗng (cần thiết cho một số thư viện)
    public CartItem() {
    }

    // Constructor mà file OrderServiceTest của bạn đang dùng
    public CartItem(Long productId, String name, Long price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // --- Bắt đầu Getters và Setters ---

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // --- Kết thúc Getters và Setters ---
}