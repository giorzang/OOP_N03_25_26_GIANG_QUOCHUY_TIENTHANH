import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    // CREATE product
    public void addProduct(Product newProduct) {
        for (Product product : products) {
            if (product.getId() == newProduct.getId()) {
                System.out.println("Product with ID " + newProduct.getId() + " already exists");
                return;
            }
        }
        products.add(newProduct);
        System.out.println("Added product " + newProduct.getName() + " successfully");
    }

    // READ product by ID
    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    // READ all products
    public List<Product> getAllProducts() {
        return products;
    }

    // UPDATE product
    public void updateProduct(int id, String name, String description, int price, int stock, String image, int categoryId) {
        Product product = getProductById(id);

        if (product == null) {
            System.out.println("Product with ID " + id + " not found");
            return;
        }

        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setStock(stock);
        product.setImage(image);
        product.setCategoryId(categoryId);

        System.out.println("Updated product " + id + " successfully");
    }

    // DELETE product
    public void deleteProduct(int id) {
        Product product = getProductById(id);

        if (product == null) {
            System.out.println("Product with ID " + id + " not found");
            return;
        }

        products.remove(product);
        System.out.println("Deleted product " + id + " successfully");
    }
}
