public class TestCategory {
    public static void testGetCategory() {
        Category c = new Category(1, "Sách Văn học", 101);
        System.out.println("id = " + c.getId());
        System.out.println("description = " + c.getDescription());
        System.out.println("productId (mã sách) = " + c.getProductId());
    }

    public static void testSetCategory() {
        Category c = new Category(2, "Sách Khoa học", 202);
        c.setId(3);
        c.setDescription("Sách Lịch sử");
        c.setProductId(303);

        System.out.println("id = " + c.getId());
        System.out.println("description = " + c.getDescription());
        System.out.println("productId (mã sách) = " + c.getProductId());
    }

    public static void testUpdateCategory() {
        Category c = new Category(4, "Sách Công nghệ", 404);
        c.update("Sách Thiếu nhi", 505);

        System.out.println("id = " + c.getId());
        System.out.println("description = " + c.getDescription());
        System.out.println("productId (mã sách) = " + c.getProductId());
    }
}
