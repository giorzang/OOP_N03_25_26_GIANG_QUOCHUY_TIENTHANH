public class ProductServiceTest {
    public static void runTests() {
        System.out.println("\n--- PRODUCT SERVICE TEST ---");
        ProductService productService = new ProductService();

        // CREATE
        productService.addProduct(new Product(1, "Rau Muống", "Rau tươi", 20000, 100, "img1.jpg"));
        productService.addProduct(new Product(2, "Cà Chua", "Cà sạch", 30000, 50, "img2.jpg"));

        // READ
        System.out.println("All products:");
        productService.getAllProducts();

        // UPDATE
        productService.updateProduct(2, "Cà Chua Đà Lạt", "Cà tươi ngon", 35000, 60, "img2new.jpg");
        productService.getAllProducts();

        // DELETE
        productService.deleteProduct(1);
        productService.getAllProducts();
    }
}
