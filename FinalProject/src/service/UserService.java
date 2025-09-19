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

<<<<<<< HEAD
    // DELETE user
    public void deleteUser(int id) {
        User user = getUserById(id);

        if (user == null || user.getIsActive() == true) {
            System.out.println("User " + id + " not found");
        }
        user.setIsActive(false);
        System.out.println("Deleted user " + id + " successfully");
    }
=======
>>>>>>> cf81cc52e30c78e179bc6078fe5a902cae9a5f01
    
    public boolean login(String email, String password) {
        for (User user: users) {
            if (user.getEmail().equals(email) && user.getIsActive() == true && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void logout() {
        System.out.println("Logged out");
    }
}
