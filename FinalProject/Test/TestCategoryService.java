public class TestCategoryService {
    public static void main(String[] args) {
        CategoryService service = new CategoryService();

        // 1. Thêm category
        System.out.println("=== TEST ADD CATEGORY ===");
        Category c1 = new Category(1, "Category A", 101);
        Category c2 = new Category(2, "Category B", 102);
        service.addCategory(c1);
        service.addCategory(c2);

        // 2. Lấy tất cả category
        System.out.println("\n=== TEST GET ALL CATEGORY ===");
        for (Category c : service.getAllCategories()) {
            System.out.println(c);
        }

        // 3. Lấy category theo id
        System.out.println("\n=== TEST GET CATEGORY BY ID ===");
        Category cFind = service.getCategoryById(1);
        if (cFind != null) {
            System.out.println("Tìm thấy: " + cFind);
        } else {
            System.out.println("Không tìm thấy category id=1");
        }

        // 4. Cập nhật category
        System.out.println("\n=== TEST UPDATE CATEGORY ===");
        service.updateCategory(1, "Updated Category A", 999);
        System.out.println("Sau khi update: " + service.getCategoryById(1));

        // 5. Xóa category
        System.out.println("\n=== TEST DELETE CATEGORY ===");
        service.deleteCategory(2);
        for (Category c : service.getAllCategories()) {
            System.out.println(c);
        }
    }
}
