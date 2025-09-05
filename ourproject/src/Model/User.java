package Model;

public class User {
    private static String Name;
    private static String Id;
    private static String Email;
    private static String PassWord;
    private static String PhoneNumber;

    User() {}
    public static String getName() {
        return Name;
    }
    
    public static String getId() {
        return Id;
    }

    public static String getEmail() {
        return Email;
    }

    public static String getPassWord() {
        return PassWord;
    }

    public static String getPhoneNumber() {
        return PhoneNumber;
    }
    public static void setUser(String name, String id, String email, String passWord, String phoneNumber) {
        Name = name;
        Id = id;
        Email = email;
        PassWord = passWord;
        PhoneNumber = phoneNumber;
    }
}
