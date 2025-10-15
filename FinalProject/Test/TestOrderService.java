public class TestOrderService {
    public static void testOrderService() {
        OrderService orderService = new OrderService();

        // 1. Tạo đơn hàng mới
        Order order1 = new Order(1, 101, "2025-10-15", 500.0, "Pending", "HCM City");
        Order order2 = new Order(2, 102, "2025-10-16", 750.0, "Pending", "Ha Noi");

        orderService.createOrder(order1);
        orderService.createOrder(order2);

        // 2. Xem thông tin đơn hàng
        System.out.println("\n--- XEM ĐƠN HÀNG ID = 1 ---");
        Order o = orderService.viewOrder(1);
        if (o != null) {
            System.out.println("ID: " + o.getId() +
                    ", UserID: " + o.getUserId() +
                    ", Date: " + o.getOrderDate() +
                    ", Total: " + o.getTotalAmount() +
                    ", Status: " + o.getStatus());
        }

        // 3. Cập nhật đơn hàng
        System.out.println("\n--- CẬP NHẬT ĐƠN HÀNG ID = 2 ---");
        orderService.updateOrder(2, "Shipping", "Da Nang", 820.0, "2025-10-17");

        // 4. Hủy đơn hàng
        System.out.println("\n--- HỦY ĐƠN HÀNG ID = 1 ---");
        orderService.cancelOrder(1);

        // 5. Hiển thị tất cả đơn hàng
        System.out.println("\n--- DANH SÁCH TẤT CẢ ĐƠN HÀNG ---");
        orderService.showAllOrders();
    }
}
