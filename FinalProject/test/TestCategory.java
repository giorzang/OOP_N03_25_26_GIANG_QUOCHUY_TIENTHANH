public class TestCategory {
    public static void testGetCategory() {
        Category c = new Category(1, "Quần áo nam", 101);
        System.out.println("id = " + c.getId());
        System.out.println("description = " + c.getDescription());
        System.out.println("productId = " + c.getProductId());
    }

    public static void testSetCategory() {
        Category c = new Category(2, "Phụ kiện điện tử", 202);
        c.setId(3);
        c.setDescription("Đồ gia dụng");
        c.setProductId(303);

        System.out.println("id = " + c.getId());
        System.out.println("description = " + c.getDescription());
        System.out.println("productId = " + c.getProductId());
    }

    public static void testUpdateCategory() {
        Category c = new Category(4, "Thời trang nữ", 404);
        c.update("Thời trang trẻ em", 505);

        System.out.println("id = " + c.getId());
        System.out.println("description = " + c.getDescription());
        System.out.println("productId = " + c.getProductId());
    }
}
