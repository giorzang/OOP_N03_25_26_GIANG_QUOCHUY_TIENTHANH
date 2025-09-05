import Model.User;

public class TestUser {


    public static void test(){
        User.setUser("test", "u01", "u01@gmail.com", "****", "091234566");
        System.out.println(User.getName());
    }
    
}
