package com.example.servingwebcontent.model;

// Class này không cần @Test, nó chỉ là một class utility để kiểm tra Model thủ công.

public class TestUser {
    public static void test() {
        // --- BƯỚC 1: CHUẨN BỊ ROLE ENTITY ---
        // Vì Role không còn là Enum, ta phải tạo một đối tượng Role Entity
        Role adminRole = new Role();
        adminRole.setId(1L);
        adminRole.setName("ADMIN"); // Tên Role chính xác

        // Khởi tạo đối tượng User
        User u = new User();
        
        // Gán các giá trị
        u.setId(1L);
        u.setEmail("giorzang@gmail.com"); 

        u.setPassword("Pass123");
        
        // SỬA LỖI 1: Thay thế setFullName bằng setName (do bạn đã đổi tên trường)
        u.setName("Vu Truong Giang"); 
        
        u.setAddress("So 1, Nguyen Trac, Yen Nghia, Ha Dong, Ha Noi");
        u.setPhone("0123456789");
        
        // SỬA LỖI 2: Thay thế Role.ADMIN (biến tĩnh Enum) bằng adminRole (Role Entity)
        u.setRole(adminRole); 

        // In các giá trị
        System.out.println("--- Kiểm tra User Model ---");
        System.out.println("ID: " + u.getId());
        System.out.println("Email: " + u.getEmail());
        System.out.println("Password: " + u.getPassword());
        
        // SỬA LỖI 3: Thay thế getFullName bằng getName
        System.out.println("Full Name: " + u.getName()); 
        
        System.out.println("Address: " + u.getAddress());
        System.out.println("Phone: " + u.getPhone());
        
        // Lấy tên Role từ Entity
        System.out.println("Role ID: " + u.getRole().getId());
        System.out.println("Role Name: " + u.getRole().getName());
        System.out.println("---------------------------");
    }
    
    // Nếu bạn muốn chạy thủ công, thêm main method:
    public static void main(String[] args) {
        test();
    }
}