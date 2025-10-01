public class TestProductService {
    public static void main(String[] args) {
        ProductService service = new ProductService();

        // 1. Test thêm sản phẩm
        Product p1 = new Product(1, "Áo thun", 120000, 10, "Quần áo", "Áo thun trắng cotton", "ao1.jpg");
        Product p2 = new Product(2, "Quần jean", 300000, 5, "Quần áo", "Quần jean xanh", "quan1.jpg");
        Product p3 = new Product(3, "Giày sneaker", 500000, 8, "Giày dép", "Giày thể thao trắng", "giay1.jpg");

        service.addProduct(p1);
        service.addProduct(p2);
        service.addProduct(p3);

        // 2. Test hiển thị tất cả sản phẩm
        System.out.println("\nDanh sách sản phẩm hiện tại:");
        service.showAll();

        // 3. Test update sản phẩm
        System.out.println("\nCập nhật sản phẩm ID = 2:");
        service.updateProduct(2, "Quần jean rách gối", 350000, 7, "Quần áo", "Quần jean xanh kiểu rách", "quan2.jpg");
        service.showAll();

        // 4. Test update sản phẩm không tồn tại
        System.out.println("\nCập nhật sản phẩm ID = 10:");
        service.updateProduct(10, "Noname", 0, 0, "None", "Không có", "none.jpg");

        // 5. Test xóa sản phẩm
        System.out.println("\nXóa sản phẩm ID = 1:");
        service.deleteProduct(1);
        service.showAll();

        // 6. Test xóa sản phẩm không tồn tại
        System.out.println("\nXóa sản phẩm ID = 99:");
        service.deleteProduct(99);
    }
}