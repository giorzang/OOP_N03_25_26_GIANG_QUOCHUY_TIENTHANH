import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private List<Category> categories = new ArrayList<>();

    public void addCategory(Category c) {
        categories.add(c);
        System.out.println("Added category " + c.getId() + " successfully");
    }

    public List<Category> getAllCategories() {
        return categories;
    }

    public Category getCategoryById(int id) {
        for (Category c : categories) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public void updateCategory(int id, String description, int productId) {
        Category c = getCategoryById(id);
        if (c == null) {
            System.out.println("Category " + id + " not found");
            return;
        }
        c.update(description, productId);
        System.out.println("Updated category " + id + " successfully");
    }

    public void deleteCategory(int id) {
        Category temp = null;
        for (Category c : categories) {
            if (c.getId() == id) {
                temp = c;
                break;
            }
        }
        if (temp != null) {
            categories.remove(temp);
            System.out.println("Deleted category with ID = " + id);
        } else {
            System.out.println("Category " + id + " not found");
        }
    }
}
