import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();

    public void createUser(User newUser) {
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

    public void updateUser(int id, String name, String email, String password, String phone) {
        User user = getUserById(id);
        
        if (user == null) {
            System.out.println("User " + id + " not found");
        }
        user.update(name, email, password, phone);
        System.out.println("Updated user " + id + " successfully");
    }

    
}
