import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    // CREATE
    public void addProduct(Product p) {
        products.add(p);
        System.out.println("Added: " + p);
    }

    // READ
    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // UPDATE
    public void updateProduct(int id, String title, int price, int stock, String category, String description, String image) {
        Product p = getProductById(id);
        if (p != null) {
            p.upDate(title, price, stock, category, description, image);
            System.out.println("Updated: " + p);
        } else {
            System.out.println("Product not found!");
        }
    }

    // DELETE
    public void deleteProduct(int id) {
        products.removeIf(p -> p.getId() == id);
        System.out.println("Deleted product with id=" + id);
    }
}
