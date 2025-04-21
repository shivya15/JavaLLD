package Splitwise.Service;

import java.util.HashMap;
import java.util.Map;

import Instagram.Entity.User;

public class UserService implements UserServiceInterface {
    private Map<Integer, User> users = new HashMap<>();
    private int nextUserId = 1;

    @Override
    public int addUser(String name, String phoneNo, String email) {
        User user = new User(nextUserId, name, phoneNo, email);
        users.put(nextUserId, user);
        return nextUserId++;
    }

    @Override
    public User getUser(int userId) {
        return users.get(userId);
    }

    @Override
    public Map<Integer, User> getAllUsers() {
        return users;
    }
}
