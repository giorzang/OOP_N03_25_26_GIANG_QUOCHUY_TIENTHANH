import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products = new ArrayList<>(); 

    // Create: them mot san pham moi
    public void addProduct(Product p) {
        products.add(p);
        System.out.println("Da them san pham co ID: " + p.getId());
    }

    // Read: hien thi tat ca san pham
    public void showAll() {
        for(Product p : products) {
            System.out.println(p);
        }
    }

    public List<Product> getAllProducts() {
        return products;
    }

    // Update: cap nhat san pham theo id
    public void updateProduct(int id, String name, int price, int stock, String category, String description, String image) {
        for(Product p : products) {
            if(p.getId() == id) {
                p.upDate(name, price, stock, category, description, image);
                System.out.println("Da cap nhat san pham co ID: " + id);
                return;
            }
        }
        System.out.println("Khong tim thay san pham co ID: " + id);
    }

    // Delete: xoa san pham theo id
    public void deleteProduct(int id) {
        Product temp = null;
        for(Product p : products) {
            if(p.getId() == id) {
                temp = p;
                break;
            }
        }
        if(temp != null) {
            products.remove(temp);
            System.out.println("Da xoa san pham co ID = " + id);
        } else {
            System.out.println("Khong tim thay san pham co ID = " + id);
        }
    }
}
