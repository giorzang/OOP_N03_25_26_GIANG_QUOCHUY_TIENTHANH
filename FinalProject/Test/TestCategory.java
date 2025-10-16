public class CategoryServiceTest {
    public static void runTests() {
        System.out.println("\n--- CATEGORY SERVICE TEST ---");
        CategoryService categoryService = new CategoryService();

        // CREATE
        categoryService.addCategory(new Category(1, "Rau Lá", 1));
        categoryService.addCategory(new Category(2, "Củ Quả", 2));

        // READ
        categoryService.getAllCategories();

        // UPDATE
        categoryService.updateCategory(2, "Củ - Quả", 3);
        categoryService.getAllCategories();

        // DELETE
        categoryService.deleteCategory(1);
        categoryService.getAllCategories();
    }
}
