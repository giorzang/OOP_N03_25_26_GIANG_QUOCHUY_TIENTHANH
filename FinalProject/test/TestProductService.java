public class TestProductService {
    public static void main(String[] args) {
        // Tạo đối tượng service để quản lý sản phẩm
        ProductService service = new ProductService();

        // Tạo một số sản phẩm mẫu
        Product p1 = new Product(1, "Ao thun", 100, 10, "Thoi trang", "Ao thun trang", "ao1.jpg");
        Product p2 = new Product(2, "Quan jean", 200, 5, "Thoi trang", "Quan jean xanh", "quan1.jpg");
        Product p3 = new Product(3, "Giay the thao", 500, 7, "Giay dep", "Giay Nike", "giay1.jpg");

        // ===== TEST CREATE =====
        service.addProduct(p1);
        service.addProduct(p2);
        service.addProduct(p3);

        System.out.println("\n=== Danh sach san pham sau khi them ===");
        service.showAll();

        // ===== TEST UPDATE =====
        service.updateProduct(2, "Quan kaki", 250, 8, "Thoi trang", "Quan kaki mau be", "quan_kaki.jpg");

        System.out.println("\n=== Danh sach san pham sau khi cap nhat ===");
        service.showAll();

        // ===== TEST DELETE =====
        // Mở comment đoạn code delete trong ProductService trước khi test
        // service.deleteProduct(1);

        // System.out.println("\n=== Danh sach san pham sau khi xoa ===");
        // service.showAll();
    }
}
