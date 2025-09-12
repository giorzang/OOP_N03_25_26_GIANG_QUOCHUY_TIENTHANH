import model.User;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\nTest Get:");
        TestUser.testGet();

        System.out.println("\nTest Set:");
        TestUser.testSet();

        System.out.println("\nTest Login:");
        TestUser.testLogin();

        System.out.println("\nTest Update:");
        TestUser.testUpdate();
    }
}
