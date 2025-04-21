package Splitwise.Service;

import java.util.Map;

import Instagram.Entity.User;

public interface UserServiceInterface {
    int addUser(String name, String phoneNo, String email);

    User getUser(int userId);

    Map<Integer, User> getAllUsers();
}
