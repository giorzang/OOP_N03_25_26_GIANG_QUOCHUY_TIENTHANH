public class App {
    public static void main(String[] args) {
        System.out.println("=== RUNNING ALL TESTS ===");

        UserServiceTest.runTests();
        ProductServiceTest.runTests();
        CategoryServiceTest.runTests();
        OrderServiceTest.runTests();

        System.out.println("=== ALL TESTS FINISHED ===");
    }
}
