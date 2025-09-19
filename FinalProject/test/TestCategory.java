public class TestCategory {
    public static void testGetCategory() {
        Category c = new Category(1, "Áo nam", 101);
        System.out.println("id: " + c.getId());
        System.out.println("description: " + c.getDescription());
        System.out.println("productId: " + c.getProductId());
    }

    public static void testSetCategory() {
        Category c = new Category(2, "Quần nữ", 202);
        c.setId(3);
        c.setDescription("Phụ kiện thời trang");
        c.setProductId(303);

        System.out.println("id: " + c.getId());
        System.out.println("description: " + c.getDescription());
        System.out.println("productId: " + c.getProductId());
    }

    public static void testUpdate() {
        Category c = new Category(4, "Giày dép", 404);
        c.update("Giày thể thao", 505);

        System.out.println("id: " + c.getId());
        System.out.println("description: " + c.getDescription());
        System.out.println("productId: " + c.getProductId());
    }
}
