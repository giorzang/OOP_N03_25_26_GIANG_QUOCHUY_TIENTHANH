public class TestProduct {
    public void Test() {
        ProductService productService = new ProductService();

        // CREATE
        System.out.println(">>> THEM SAN PHAM");
        Product p1 = new Product(1, "Harry Potter", 120000, 10, "Fantasy", "Sach van hoc noi tieng", "harry.jpg");
        Product p2 = new Product(2, "Java Programming", 250000, 5, "Technology", "Sach hoc lap trinh Java", "java.jpg");
        productService.addProduct(p1);
        productService.addProduct(p2);

        // READ
        System.out.println("\n>>> DANH SACH SAN PHAM");
        productService.showAll();

        // UPDATE
        System.out.println("\n>>> CAP NHAT SAN PHAM ID=1");
        productService.updateProduct(1, "Harry Potter - Update", 150000, 8, "Fantasy", "Phien ban moi nhat", "harry_new.jpg");

        // DELETE
        System.out.println("\n>>> XOA SAN PHAM ID=2");
        productService.deleteProduct(2);

        // READ again
        System.out.println("\n>>> DANH SACH SAU KHI XOA");
        productService.showAll();
    }
}
