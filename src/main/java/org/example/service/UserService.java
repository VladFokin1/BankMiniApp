package org.example.service;

import org.example.Loggable;
import org.example.model.User;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final List<User> userList;
    private final AccountService accountService;

    public UserService(@Lazy AccountService accountService) {
        userList = new ArrayList<>();
        this.accountService = accountService;
    }

    public User createUser(String username) {
        User newUser = new User(username);
        userList.add(newUser);
        accountService.createAccount(newUser.getId());
        return newUser;
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
