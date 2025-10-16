import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<Order> orders = new ArrayList<>();

    // Create: Thêm đơn hàng mới
    public void addOrder(Order order) {
        orders.add(order);
        System.out.println("Đã thêm đơn hàng có ID: " + order.getId());
    }
//dfádfsa
    // Read: Hiển thị toàn bộ đơn hàng
    public void showAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("Không có đơn hàng nào!");
            return;
        }
        for (Order o : orders) {
            System.out.println("ID: " + o.getId() +
                               ", UserID: " + o.getUserId() +
                               ", OrderDate: " + o.getOrderDate() +
                               ", Total: " + o.getTotalAmount() +
                               ", Status: " + o.getStatus() +
                               ", Address: " + o.getShippingAddress());
        }
    }

    // Update: Cập nhật thông tin đơn hàng theo ID
    public void updateOrder(int id, double newTotal, String newStatus, String newAddress) {
        for (Order o : orders) {
            if (o.getId() == id) {
                o.setTotalAmount(newTotal);
                o.setStatus(newStatus);
                o.setShippingAddress(newAddress);
                System.out.println("Đã cập nhật đơn hàng ID: " + id);
                return;
            }
        }
        System.out.println("Không tìm thấy đơn hàng có ID: " + id);
    }

    // Delete: Xóa đơn hàng theo ID
    public void deleteOrder(int id) {
        for (Order o : orders) {
            if (o.getId() == id) {
                orders.remove(o);
                System.out.println("Đã xóa đơn hàng ID: " + id);
                return;
            }
        }
        System.out.println("Không tìm thấy đơn hàng có ID: " + id);
    }

    // Tìm đơn hàng theo ID
    public Order getOrderById(int id) {
        for (Order o : orders) {
            if (o.getId() == id) {
                return o;
            }
        }
        return null;
    }
}
