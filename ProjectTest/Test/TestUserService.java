public class UserServiceTest {
    public static void runTests() {
        System.out.println("\n--- USER SERVICE TEST ---");
        UserService userService = new UserService();

        // CREATE
        userService.addUser(new User(1, "Giang", "giang@gmail.com", "123", "111", "HN", true));
        userService.addUser(new User(2, "Thanh", "thanh@gmail.com", "456", "222", "HCM", true));

        // READ
        System.out.println("All users:");
        userService.showAllUsers();

        // UPDATE
        userService.updateUser(2, "Thanh Updated", "thanhnew@gmail.com", "987", "2222", "DN", true);
        userService.showAllUsers();

        // DELETE
        userService.deleteUser(1);
        userService.showAllUsers();
    }
}
