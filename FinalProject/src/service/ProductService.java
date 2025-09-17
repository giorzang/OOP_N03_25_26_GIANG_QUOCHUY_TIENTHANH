import java.util.ArrayList;
import java.util.List;
public class ProductService {
    private List<Product> products = new ArrayList<>(); 

    //Create: them mot thanh vien moi
    public void addProduct(Product p) {
        products.add(p);
    }
    //Read: doc het cac phan tu trong sanh sach mang
    public void showAll() {
        for(Product p : products) {
            System.out.println(p);
        }
    }
    public List<Product> getAllProducts() {
        return products;
    }
    //Update: cap nhap san phan theo id
    public void updateProduct(int id, String name, int price, int stock, String category, String description, String image) {
        for(Product p : products) {
            if(p.getId() == id) {
                p.upDate(name, price, stock, category, description, image);
                System.out.println("Da cap nhap san phan co ID: " + id);
                return;
            }
            System.out.println("Khong tim thay san pham co ID: " + id);
        }
    }
    //Delete: xoa san pham theo id
    public void deleteProduct(int id) {
        Product temp = null;
        for(Product p : products) {
            if(p.getId() == id) {
                temp = p;
                break;
            }
        }
        if(temp != null) {
            products.remove(id);
            System.out.println("Đã xóa sản phẩm có ID = " + id);
        } else {
             System.out.println("Không tìm thấy sản phẩm có ID = " + id);
        }
    }
}