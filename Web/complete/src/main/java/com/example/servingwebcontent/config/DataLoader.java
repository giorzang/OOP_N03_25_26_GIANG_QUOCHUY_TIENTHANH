package com.example.servingwebcontent.config;

import com.example.servingwebcontent.model.Category;
import com.example.servingwebcontent.model.Product;
import com.example.servingwebcontent.model.Role;
import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.repositories.CategoryRepository; 
import com.example.servingwebcontent.repositories.ProductRepository;
import com.example.servingwebcontent.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

// BỔ SUNG IMPORT: Cần import BigDecimal để xử lý giá
import java.math.BigDecimal; 

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(CategoryRepository categoryRepository,
                      ProductRepository productRepository,
                      UserRepository userRepository,
                      PasswordEncoder passwordEncoder) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Chỉ chạy Data Seeding nếu database chưa có dữ liệu User
        if (userRepository.count() > 0 && categoryRepository.count() > 0) {
            System.out.println("Dữ liệu mẫu đã tồn tại. Bỏ qua Data Seeding.");
            return;
        }

        System.out.println("Bắt đầu chèn dữ liệu mẫu...");

        // 1. Tạo User Mẫu (Admin và Khách hàng)
        
        // --- TẠO ADMIN ---
        if (userRepository.findByEmail("admin@rausach.com").isEmpty()) {
            User admin = new User();
            // LỖI: setUsername đã bị xóa khỏi User.java. 
            // Chúng ta không cần setUsername vì đã dùng email làm ID đăng nhập.
            // admin.setUsername("admin"); // <-- DÒNG NÀY ĐƯỢC XÓA
            
            admin.setFullName("Admin Quản Trị");
            admin.setEmail("admin@rausach.com"); // <-- Giữ nguyên email
            admin.setPassword(passwordEncoder.encode("123456"));
            admin.setRole(Role.ADMIN);
            userRepository.save(admin);
        }

        // --- TẠO CUSTOMER ---
        if (userRepository.findByEmail("customer@gmail.com").isEmpty()) {
            User customer = new User();
            // LỖI: setUsername đã bị xóa khỏi User.java. 
            // Chúng ta không cần setUsername.
            // customer.setUsername("customer"); // <-- DÒNG NÀY ĐƯỢC XÓA
            
            customer.setFullName("Khách Hàng Thử Nghiệm");
            customer.setEmail("customer@gmail.com"); // <-- Giữ nguyên email
            customer.setPassword(passwordEncoder.encode("123456"));
            customer.setRole(Role.CUSTOMER);
            userRepository.save(customer);
        }
        
        // 2. Tạo Category Mẫu (Giữ nguyên)
        // ... (Phần tạo Category và Product không cần thay đổi)
        
        // (Để đảm bảo tính nhất quán, tôi sẽ chỉ thêm logic kiểm tra `isEmpty()` vào User)
        
        // TẠO CATEGORY MẪU
        Category rauAnLa = new Category();
        rauAnLa.setName("Rau Ăn Lá");
        rauAnLa.setDescription("Các loại rau xanh, tươi, sạch.");
        categoryRepository.save(rauAnLa);

        Category cuQua = new Category();
        cuQua.setName("Củ và Quả");
        cuQua.setDescription("Các loại củ, quả sạch theo mùa.");
        categoryRepository.save(cuQua);

        // 3. Tạo Product Mẫu (Giữ nguyên)
        Product caiXanh = new Product();
        caiXanh.setName("Cải Xanh Hữu Cơ");
        caiXanh.setDescription("Cải xanh được trồng theo phương pháp hữu cơ.");
        caiXanh.setPrice(BigDecimal.valueOf(35000)); 
        caiXanh.setStock(10);
        caiXanh.setCategory(rauAnLa);
        caiXanh.setImageUrl("https://placehold.co/400x300/0d9488/FFFFFF?text=Cai+Xanh");
        productRepository.save(caiXanh);

        Product xaLach = new Product();
        xaLach.setName("Xà Lách Xoong Đà Lạt");
        xaLach.setDescription("Xà lách tươi ngon, nhập từ Đà Lạt.");
        xaLach.setPrice(BigDecimal.valueOf(40000));
        xaLach.setStock(5);
        xaLach.setCategory(rauAnLa);
        xaLach.setImageUrl("https://placehold.co/400x300/0d9488/FFFFFF?text=Xa+Lach");
        productRepository.save(xaLach);

        Product caChua = new Product();
        caChua.setName("Cà Chua Bi Sạch");
        caChua.setDescription("Cà chua bi mọng nước, không hóa chất.");
        caChua.setPrice(BigDecimal.valueOf(55000));
        caChua.setStock(20);
        caChua.setCategory(cuQua);
        caChua.setImageUrl("https://placehold.co/400x300/0d9488/FFFFFF?text=Ca+Chua");
        productRepository.save(caChua);

        System.out.println("Đã chèn dữ liệu mẫu thành công!");
    }
}