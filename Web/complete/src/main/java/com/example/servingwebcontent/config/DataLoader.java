package com.example.servingwebcontent.config;

import com.example.servingwebcontent.model.Category;
import com.example.servingwebcontent.model.Product;
import com.example.servingwebcontent.model.Role; // Role Entity
import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.repositories.CategoryRepository; 
import com.example.servingwebcontent.repositories.ProductRepository;
import com.example.servingwebcontent.repositories.UserRepository;
import com.example.servingwebcontent.repositories.RoleRepository; // BỔ SUNG
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal; 
import java.util.Optional; 

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository; // BỔ SUNG

    public DataLoader(CategoryRepository categoryRepository,
                      ProductRepository productRepository,
                      UserRepository userRepository,
                      PasswordEncoder passwordEncoder,
                      RoleRepository roleRepository) { // BỔ SUNG VÀO CONSTRUCTOR
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository; // GÁN
    }

    @Override
    public void run(String... args) throws Exception {
        // Kiểm tra cơ bản
        if (categoryRepository.count() > 0 && userRepository.count() > 0) {
            System.out.println("Dữ liệu mẫu đã tồn tại. Bỏ qua Data Seeding.");
            return;
        }

        System.out.println("Bắt đầu chèn dữ liệu mẫu...");

        // =========================================================
        // BƯỚC 1: TẠO VÀ LƯU ROLE ENTITY (BẮT BUỘC)
        // =========================================================
        Role adminRole = roleRepository.findByName("ADMIN");
        if (adminRole == null) {
            adminRole = new Role("ADMIN");
            roleRepository.save(adminRole);
        }

        Role customerRole = roleRepository.findByName("CUSTOMER");
        if (customerRole == null) {
            customerRole = new Role("CUSTOMER");
            roleRepository.save(customerRole);
        }

        // =========================================================
        // BƯỚC 2: TẠO USER VÀ GÁN ROLE ENTITY
        // =========================================================
        
        // --- TẠO ADMIN ---
        if (userRepository.findByEmail("admin@rausach.com").isEmpty()) {
            User admin = new User();
            admin.setName("Admin Quản Trị"); // Đã sửa từ setFullName
            admin.setEmail("admin@rausach.com"); 
            admin.setPassword(passwordEncoder.encode("123456"));
            admin.setRole(adminRole); // Gán Role Entity
            userRepository.save(admin);
        }

        // --- TẠO CUSTOMER ---
        if (userRepository.findByEmail("customer@gmail.com").isEmpty()) {
            User customer = new User();
            customer.setName("Khách Hàng Thử Nghiệm"); // Đã sửa từ setFullName
            customer.setEmail("customer@gmail.com"); 
            customer.setPassword(passwordEncoder.encode("123456"));
            customer.setRole(customerRole); // Gán Role Entity
            userRepository.save(customer);
        }
        
        // ... (Phần tạo Category và Product giữ nguyên) ...
        
        System.out.println("Đã chèn dữ liệu mẫu thành công!");
    }
}