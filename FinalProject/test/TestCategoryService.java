public class TestCategoryService {
    public static void testAddAndGetAll() {
        CategoryService service = new CategoryService();
        Category c1 = new Category(1, "Quần áo nam", 101);
        Category c2 = new Category(2, "Giày thể thao", 102);

        service.addCategory(c1);
        service.addCategory(c2);

        System.out.println("===== Danh sách Category =====");
        for (Category c : service.getAllCategories()) {
            System.out.println("id: " + c.getId() 
                + ", description: " + c.getDescription() 
                + ", productId: " + c.getProductId());
        }
    }

    public static void testUpdate() {
        CategoryService service = new CategoryService();
        Category c1 = new Category(1, "Áo sơ mi", 201);
        service.addCategory(c1);

        System.out.println("Trước khi update:");
        System.out.println("id: " + c1.getId() + ", description: " + c1.getDescription());

        service.updateCategory(1, "Áo sơ mi trắng", 202);

        System.out.println("Sau khi update:");
        Category updated = service.getCategoryById(1);
        System.out.println("id: " + updated.getId() 
            + ", description: " + updated.getDescription() 
            + ", productId: " + updated.getProductId());
    }

    public static void testDelete() {
        CategoryService service = new CategoryService();
        Category c1 = new Category(1, "Phụ kiện", 301);
        Category c2 = new Category(2, "Đồng hồ", 302);
        service.addCategory(c1);
        service.addCategory(c2);

        System.out.println("Danh sách trước khi xóa:");
        for (Category c : service.getAllCategories()) {
            System.out.println("id: " + c.getId() + ", description: " + c.getDescription());
        }

        service.deleteCategory(1);

        System.out.println("Danh sách sau khi xóa:");
        for (Category c : service.getAllCategories()) {
            System.out.println("id: " + c.getId() + ", description: " + c.getDescription());
        }
    }

    public static void main(String[] args) {
        testAddAndGetAll();
        System.out.println("\n----------------------\n");
        testUpdate();
        System.out.println("\n----------------------\n");
        testDelete();
    }
}
