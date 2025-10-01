public class TestProduct {
    public static void main(String[] args) {
        // 1. Tạo sản phẩm bằng constructor
        Product p = new Product(1, "Áo thun", 120000, 10, "Quần áo", "Áo thun cotton trắng", "ao1.jpg");

        System.out.println("=== Thông tin ban đầu ===");
        System.out.println(p); // gọi toString()

        // 2. Test getId()
        System.out.println("\n=== Test getId() ===");
        System.out.println("ID sản phẩm: " + p.getId());

        // 3. Test upDate()
        System.out.println("\n=== Cập nhật thông tin sản phẩm ===");
        p.upDate("Áo hoodie", 250000, 5, "Áo khoác", "Áo hoodie đen ấm áp", "hoodie.jpg");
        System.out.println(p);

        // 4. Test cập nhật lần nữa để chắc chắn hoạt động đúng
        System.out.println("\n=== Cập nhật lần 2 ===");
        p.upDate("Giày sneaker", 500000, 7, "Giày dép", "Giày sneaker trắng", "sneaker.jpg");
        System.out.println(p);
    }
}
