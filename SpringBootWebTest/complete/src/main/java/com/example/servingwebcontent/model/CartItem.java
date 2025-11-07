package com.example.servingwebcontent.model; 

// BỔ SUNG IMPORT: Cần import BigDecimal
import java.math.BigDecimal; 

/**
 * Đây là một POJO (Plain Old Java Object) dùng để đại diện 
 * cho một món hàng trong giỏ hàng (không phải là một Entity lưu trong CSDL).
 */
public class CartItem {

    private Long productId;
    private String name;
    // SỬA LỖI: Thay Long bằng BigDecimal
    private BigDecimal price; 
    private int quantity;

    // Constructor rỗng (cần thiết cho một số thư viện)
    public CartItem() {
    }

    // SỬA LỖI CONSTRUCTOR: Thay Long price bằng BigDecimal price
    public CartItem(Long productId, String name, BigDecimal price, int quantity) {
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

    // SỬA LỖI GETTER: Trả về BigDecimal
    public BigDecimal getPrice() {
        return price;
    }

    // SỬA LỖI SETTER: Chấp nhận BigDecimal
    public void setPrice(BigDecimal price) {
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