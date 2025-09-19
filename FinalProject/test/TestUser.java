public class TestUser {
    public static void testGet() {
        User u = new User(1, "Giang", "giorzang@gmail.com", "pass123", "0818778269");
        
        System.out.println("id = " + u.getId());
        System.out.println("name = " + u.getName());
        System.out.println("email = " + u.getEmail());
        System.out.println("password = " + u.getPassword());
        System.out.println("phone = " + u.getPhone());
    }

    public static void testSet() {
        User u = new User(1, "Giang", "giorzang@gmail.com", "pass123", "0818778269");

        u.setId(2);
        u.setName("Thanh");
        u.setEmail("Thank-05@gmail.com");
        u.setPassword("pass321");
        u.setPhone("0123456789");        

        System.out.println("id = " + u.getId());
        System.out.println("name = " + u.getName());
        System.out.println("email = " + u.getEmail());
        System.out.println("password = " + u.getPassword());
        System.out.println("phone = " + u.getPhone());
    }
    
    public static void testLogin() {
        User u = new User(1, "Giang", "giorzang@gmail.com", "pass123", "0818778269");

        System.out.println("(" + u.login("giorzang@gmail.com", "pass321") + ") Sai email hoac mat khau.");
        System.out.println("(" + u.login("giorzang@gmail.com", "pass123") + ") Dang nhap thanh cong!");
    }

    public static void testUpdate() {
        User u = new User(1, "Giang", "giorzang@gmail.com", "pass123", "0818778269");

        u.update("Thanh", "Thank-05@gmail.com", "pass321", "0123456789");

        System.out.println("id = " + u.getId());
        System.out.println("name = " + u.getName());
        System.out.println("email = " + u.getEmail());
        System.out.println("password = " + u.getPassword());
        System.out.println("phone = " + u.getPhone());
    }
}