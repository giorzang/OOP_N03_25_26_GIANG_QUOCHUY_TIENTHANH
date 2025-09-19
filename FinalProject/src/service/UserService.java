import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();

    // CREATE user
    public void register(User newUser) {
        for (User user: users) {
            if (user.getEmail() == newUser.getEmail()) {
                System.out.println("User already exists");
                return;
            }
        }
        users.add(newUser);
        System.out.println("Added user " + newUser.getName() + " successfully");
    }

    // READ user
    public User getUserById(int id) {
        for (User user: users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    public List<User> getAllUsers() {
        return users;
    }

    // UPDATE user
    public void updateUser(int id, String name, String email, String phone, String password, String address, boolean isActive) {
        User user = getUserById(id);
        
        if (user == null || user.getIsActive() == true) {
            System.out.println("User " + id + " not found");
        }
        user.updateProfile(name, email, phone, password, address, isActive);
        System.out.println("Updated user " + id + " successfully");
    }

    // DELETE user
    
}
