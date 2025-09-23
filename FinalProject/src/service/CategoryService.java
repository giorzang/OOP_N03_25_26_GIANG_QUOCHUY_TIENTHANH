import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private List<Category> categories = new ArrayList<>();

    public void addCategory(Category c) {
        categories.add(c);
        System.out.println("Đã thêm category id=" + c.getId());
    }

    public List<Category> getAllCategories() {
        return categories;
    }

    public Category getCategoryById(int id) {
        for (Category c : categories) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public void updateCategory(int id, String description, int productId) {
        Category c = getCategoryById(id);
        if (c != null) {
            c.update(description, productId);
            System.out.println("Đã cập nhật category id=" + id);
        } else {
            System.out.println("Không tìm thấy category id=" + id);
        }
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
            System.out.println("Đã xóa category id=" + id);
        } else {
            System.out.println("Không tìm thấy category id=" + id);
        }
    }
}
