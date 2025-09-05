public class TestUser {
    public static void test() {
        User u = new User("user123", "123*****");
        System.out.println("User: " + u.getUsername() + ", password: " + u.getPassword());
    }
}