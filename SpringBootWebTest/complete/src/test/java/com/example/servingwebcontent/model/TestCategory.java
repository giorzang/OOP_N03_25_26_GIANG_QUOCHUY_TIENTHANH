package com.example.servingwebcontent.model;

public class TestCategory {
    public static void test() {
        Category c = new Category();
        c.setId(1L);
        c.setName("Cu");
        c.setDescription("Cu trong rau cu qua");

        System.out.println(c.getId());
        System.out.println(c.getName());
        System.out.println(c.getDescription());
    }
}
