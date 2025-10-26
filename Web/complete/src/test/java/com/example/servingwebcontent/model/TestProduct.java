package com.example.servingwebcontent.model;

import java.math.BigDecimal;

public class TestProduct {
    public static void test() {
        Product p = new Product();
        p.setId(1L);
        p.setName("Rau muong");
        p.setPrice(BigDecimal.valueOf(7000));
        p.setDescription("Sieu cap sach se tuoi ngon");
        p.setStock(5);
        p.setImageUrl("urlcuarau");

        System.out.println(p.getId());
        System.out.println(p.getName());
        System.out.println(p.getPrice());
        System.out.println(p.getDescription());
        System.out.println(p.getStock());
        System.out.println(p.getImageUrl());
    }
}
