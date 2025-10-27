package com.example.servingwebcontent.model;

public class TestUser {
    public static void test() {
        // Khởi tạo đối tượng User
        User u = new User();
        
        // Gán các giá trị
        u.setId(1L);
        // SỬA LỖI: Thay thế setUsername bằng setEmail
        // u.setUsername("giorzang"); // Dòng cũ gây lỗi
        u.setEmail("giorzang@gmail.com"); // <-- Dùng email làm ID đăng nhập

        u.setPassword("Pass123");
        u.setFullName("Vu Truong Giang");
        u.setAddress("So 1, Nguyen Trac, Yen Nghia, Ha Dong, Ha Noi");
        u.setPhone("0123456789");
        u.setRole(Role.ADMIN);

        // In các giá trị
        System.out.println(u.getId());
        // SỬA LỖI: Lấy giá trị email thay vì username
        System.out.println(u.getEmail()); // <-- SỬA: Thay thế getUsername() bằng getEmail()
        System.out.println(u.getPassword());
        System.out.println(u.getFullName());
        System.out.println(u.getAddress());
        System.out.println(u.getEmail());
        System.out.println(u.getPhone());
        System.out.println(u.getRole());
    }
}