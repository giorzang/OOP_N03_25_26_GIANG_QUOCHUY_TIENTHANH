import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<Order> orders = new ArrayList<>();

    // Thêm đơn hàng mới
    public void createOrder(Order order) {
        orders.add(order);
        System.out.println("Đã tạo đơn hàng với ID: " + order.getId());
    }

    // Xem thông tin đơn hàng theo ID
    public Order viewOrder(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        System.out.println("Không tìm thấy đơn hàng với ID: " + id);
        return null;
    }

    // Cập nhật đơn hàng theo ID
    public void updateOrder(int id, String status, String shippingAddress, double totalAmount, String orderDate) {
        for (Order order : orders) {
            if (order.getId() == id) {
                order.updateStatus(status, shippingAddress);
                order.setTotalAmount(totalAmount);
                order.setOrderDate(orderDate);
                System.out.println("Đã cập nhật đơn hàng với ID: " + id);
                return;
            }
        }
        System.out.println("Không tìm thấy đơn hàng với ID: " + id);
    }

    // Hủy đơn hàng theo ID
    public void cancelOrder(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                order.setStatus("Canceled");
                System.out.println("Đơn hàng " + id + " đã bị hủy.");
                return;
            }
        }
        System.out.println("Không tìm thấy đơn hàng với ID: " + id);
    }

    // Hiển thị toàn bộ đơn hàng (tuỳ chọn thêm)
    public void showAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("Chưa có đơn hàng nào.");
            return;
        }
        for (Order order : orders) {
            System.out.println("ID: " + order.getId() +
                    ", UserID: " + order.getUserId() +
                    ", Date: " + order.getOrderDate() +
                    ", Total: " + order.getTotalAmount() +
                    ", Status: " + order.getStatus());
        }
    }
}
