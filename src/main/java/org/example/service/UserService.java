package org.example.service;

import org.example.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final List<User> userList;

    public UserService() {
        userList = new ArrayList<>();
    }

    public void createUser(String username) {
        userList.add(new User(username));
    }

    public User getUserById(int id) {
        return userList.stream()
                .filter(user -> user.getId() == id)
                .findFirst().get();

    }

    public List<User> getUsersList() {
        return userList;
    }

}
