import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();

    // CREATE user
    public void register(User newUser) {
        for (User user : users) {
         
            if (user.getEmail().equals(newUser.getEmail())) {
                System.out.println("User already exists");
                return;
            }
        }
        users.add(newUser);
        System.out.println("Added user " + newUser.getName() + " successfully");
    }

    // READ user theo ID
    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    // READ tất cả user
    public List<User> getAllUsers() {
        return users;
    }

    // UPDATE user
    public void updateUser(int id, String name, String email, String phone, String password, String address, boolean isActive) {
        User user = getUserById(id);

        if (user == null || user.isActive() == false) {
            System.out.println("User " + id + " not found");
            return;
        }

        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
        user.setAddress(address);
        user.setActive(isActive);

        System.out.println("Updated user " + id + " successfully");
    }
    
    public void deleteUser(int id) {
        User user = getUserById(id);

        if (user == null || user.isActive() == false) {
            System.out.println("User " + id + " not found");
            return;
        }
        user.setActive(false);
        System.out.println("Deleted user " + id + " successfully");
    }

    // LOGIN user
    public boolean login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email)
                    && user.isActive()
                    && user.getPassword().equals(password)) {
                System.out.println("Login success");
                return true;
            }
        }
        System.out.println("Login failed");
        return false;
    }

    // LOGOUT user
    public void logout() {
        System.out.println("Logged out");
    }
}
