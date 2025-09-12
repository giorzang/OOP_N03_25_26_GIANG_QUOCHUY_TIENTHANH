package service;

import model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    // CREATE - Thêm sản phẩm mới
    public void addProduct(Product p) {
        products.add(p);
        System.out.println("Them san pham thanh cong!");
    }

    // READ - Lấy toàn bộ danh sách sản phẩm
    public List<Product> getAllProducts() {
        return products;
    }

    // READ - Tìm sản phẩm theo ID
    public Product findById(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // UPDATE - Cập nhật thông tin sản phẩm (trừ id và shopId)
    public boolean updateProduct(int id, Product newProduct) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.upDate(
                        newProduct.getName(),
                        newProduct.getPrice(),
                        newProduct.getStock(),
                        newProduct.getCategory(),
                        newProduct.getDescription(),
                        newProduct.getImage()
                );
                System.out.println("Cap nhat san pham thanh cong!");
                return true;
            }
        }
        System.out.println("Khong tim thay san pham co ID = " + id);
        return false;
    }

    // DELETE - Xóa sản phẩm theo ID
    public boolean deleteProduct(int id) {
        return products.removeIf(p -> p.getId() == id);
    }
}
