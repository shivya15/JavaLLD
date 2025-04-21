package Instagram.Service;

import java.util.HashMap;
import java.util.Map;

import Instagram.Entity.User;

public class UserService {
    private Map<Integer, User> users = new HashMap<>();
    private int nextUserId = 1;

    public int addUser(String username, String name, String email) {
        int userId = nextUserId++;
        users.put(userId, new User(userId, username, name, email));
        return userId;
        
    }
    public User getUser(int userId) {
        return users.get(userId);
    }

    public Map<Integer, User> getAllUsers() {
        return users;
    }
}
