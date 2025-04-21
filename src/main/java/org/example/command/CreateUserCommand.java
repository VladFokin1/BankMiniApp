package org.example.command;

import jdk.jshell.spi.ExecutionControl;
import org.example.Loggable;
import org.example.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

public class CreateUserCommand implements Command {

    private final UserService userService;

    public CreateUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute() {
        System.out.println("Enter login for new user:");
        Scanner sc = new Scanner(System.in);
        String login = sc.nextLine().trim();
        userService.createUser(login);
    }
}
