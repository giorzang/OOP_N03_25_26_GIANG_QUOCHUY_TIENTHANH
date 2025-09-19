public class TestUser {
    public static void testGet() {
        User u = new User(1, "Giang", "giorzang@gmail.com", "0818778269", "pass123", "DH Phenikaa", true);
        
        System.out.println("id = " + u.getId());
        System.out.println("name = " + u.getName());
        System.out.println("email = " + u.getEmail());
        System.out.println("phone = " + u.getPhone());
        System.out.println("password = " + u.getPassword());
        System.out.println("address = " + u.getAddress());
        System.out.println("isActive = " + u.getIsActive());
    }

    public static void testSet() {
        User u = new User(1, "Giang", "giorzang@gmail.com", "0818778269", "pass123", "DH Phenikaa", true);
        
        u.setId(2);
        u.setName("Thanh");
        u.setEmail("Thank-05@gmail.com");
        u.setPhone("0123456789");    
        u.setPassword("pass321");
        u.setAddress("Thanh's house");
        u.setIsActive(false);

        System.out.println("id = " + u.getId());
        System.out.println("name = " + u.getName());
        System.out.println("email = " + u.getEmail());
        System.out.println("phone = " + u.getPhone());
        System.out.println("password = " + u.getPassword());
        System.out.println("address = " + u.getAddress());
        System.out.println("isActive = " + u.getIsActive());
    }
    
    public static void testLogin() {
        User u = new User(1, "Giang", "giorzang@gmail.com", "0818778269", "pass123", "DH Phenikaa", true);
        
        System.out.println("(" + u.login("giorzang@gmail.com", "pass321") + ") Sai email hoac mat khau.");
        System.out.println("(" + u.login("giorzang@gmail.com", "pass123") + ") Dang nhap thanh cong!");
    }

    public static void testUpdate() {
        User u = new User(1, "Giang", "giorzang@gmail.com", "0818778269", "pass123", "DH Phenikaa", true);
        
        u.updateProfile("Thanh", "Thank-05@gmail.com", "0123456789", "pass321", "Thanh's house", false);

        System.out.println("id = " + u.getId());
        System.out.println("name = " + u.getName());
        System.out.println("email = " + u.getEmail());
        System.out.println("phone = " + u.getPhone());
        System.out.println("password = " + u.getPassword());
        System.out.println("address = " + u.getAddress());
        System.out.println("isActive = " + u.getIsActive());
    }
}