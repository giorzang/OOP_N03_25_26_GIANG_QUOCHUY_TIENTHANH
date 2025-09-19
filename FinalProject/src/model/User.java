public class User {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String address;
    private boolean isActive;

    public User(int id, String name, String email, String phone, String password, String address, boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.address = address;
        this.isActive = isActive;
    }

    // Get&Set Attributes
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public boolean getIsActive() { return isActive; }
    public void setIsActive(boolean isActive) { this.isActive = isActive; }

    // Methods
    public boolean login(String email, String password) {
        return this.isActive == true && this.email.equals(email) && this.password.equals(password);
    }

    public void logout() {
        System.out.println("Logged out");
    }

    public void updateProfile(String name, String email, String phone, String password, String address, boolean isActive){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.address = address;
        this.isActive = isActive;
    }

}
