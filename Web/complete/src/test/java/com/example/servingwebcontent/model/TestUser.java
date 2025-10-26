package com.example.servingwebcontent.model;

public class TestUser {
    public static void test() {
        // User u = new User(1L, "giorzang", "Pass123", "Vu Truong Giang", "add", "giorzang@gmail.com", "0123456789", Role.ADMIN);
        User u = new User();
        u.setId(1L);
        u.setUsername("giorzang");
        u.setPassword("Pass123");
        u.setFullName("Vu Truong Giang");
        u.setAddress("So 1, Nguyen Trac, Yen Nghia, Ha Dong, Ha Noi");
        u.setEmail("giorzang@gmail.com");
        u.setPhone("0123456789");
        u.setRole(Role.ADMIN);

        System.out.println(u.getId());
        System.out.println(u.getUsername());
        System.out.println(u.getPassword());
        System.out.println(u.getFullName());
        System.out.println(u.getAddress());
        System.out.println(u.getEmail());
        System.out.println(u.getPhone());
        System.out.println(u.getRole());
    }
}
