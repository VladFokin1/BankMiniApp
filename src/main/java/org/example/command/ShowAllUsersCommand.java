package org.example.command;

import org.example.model.User;
import org.example.service.UserService;

public class ShowAllUsersCommand implements Command{

    private final UserService userService;

    public ShowAllUsersCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute() {
        System.out.println("List of all users:");
        for (User user : userService.getUsersList()) {
            System.out.println(user);
        }
    }
}
