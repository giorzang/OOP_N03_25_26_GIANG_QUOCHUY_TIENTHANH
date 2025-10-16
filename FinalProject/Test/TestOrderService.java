public class OrderServiceTest {
    public static void runTests() {
        System.out.println("\n--- ORDER SERVICE TEST ---");
        OrderService orderService = new OrderService();

        // CREATE
        orderService.createOrder(
                new Order(1, 2, "2025-01-01", 1, 50000, "Hà Nội")
        );
        orderService.createOrder(
                new Order(2, 1, "2025-01-02", 0, 70000, "Đà Nẵng")
        );

        // READ
        orderService.getAllOrders();

        // UPDATE
        orderService.updateOrder(2, 1, "2025-01-03", 1, 75000, "HCM");
        orderService.getAllOrders();

        // DELETE
        orderService.cancelOrder(1);
        orderService.getAllOrders();
    }
}
