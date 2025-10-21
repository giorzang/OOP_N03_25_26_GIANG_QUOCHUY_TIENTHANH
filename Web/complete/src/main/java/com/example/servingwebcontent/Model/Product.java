package com.example.servingwebcontent.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Lớp Product này đại diện cho một thực thể (entity) sản phẩm trong cơ sở dữ liệu.
 * Nó chứa các thông tin cơ bản của một sản phẩm như tên, giá, mô tả, số lượng tồn kho
 * và danh mục mà nó thuộc về.
 */
@Entity
@Table(name = "products") // Đặt tên cho bảng trong cơ sở dữ liệu
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private String description;
    
    // Trường này dùng để quản lý số lượng sản phẩm còn lại trong kho.
    private int stock; 

    // Mối quan hệ nhiều-một: nhiều sản phẩm có thể thuộc về một danh mục.
    // Khóa ngoại trong bảng 'products' sẽ là 'category_id'.
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
}
