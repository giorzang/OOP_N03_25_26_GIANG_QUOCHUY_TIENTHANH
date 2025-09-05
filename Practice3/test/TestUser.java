public class TestUser {
    public static void main(String[] args) {
        User u1 = new User("Nguyen Van A", 20, "a@gmail.com");
        u1.displayInfo();

        u1.setAge(21);
        u1.setEmail("a123@gmail.com");
        u1.displayInfo();
    }
}
