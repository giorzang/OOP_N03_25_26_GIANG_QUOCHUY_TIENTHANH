package service;

import model.product;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<product> products = new ArrayList<>();

    // CREATE - Thêm sản phẩm mới
    public void addProduct(product p) {
        products.add(p);
        System.out.println("Them san pham thanh cong!");
    }

    // READ - Lấy toàn bộ danh sách sản phẩm
    public List<product> getAllProducts() {
        return products;
    }

    // READ - Tìm sản phẩm theo ID
    public product findById(int id) {
        for (product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // UPDATE - Cập nhật thông tin sản phẩm (trừ id và shopId)
    public boolean updateProduct(int id, product newProduct) {
        for (product p : products) {
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
