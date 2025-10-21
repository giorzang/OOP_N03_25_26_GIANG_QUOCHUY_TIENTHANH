package com.example.servingwebcontent.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ma danh muc

    @Column(nullable = false, unique = true, length = 255)
    private String name; // ten danh muc

    @Column(length = 1000)
    private String description; // mo ta danh muc

    // lien ket voi product
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

    // constructor rong bat buoc cho JPA
    public Category() {}

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // getter va setter
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
