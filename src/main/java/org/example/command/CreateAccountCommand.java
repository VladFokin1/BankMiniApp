package org.example.command;

import org.example.service.AccountService;

import java.util.Scanner;

public class CreateAccountCommand implements Command {

    private final AccountService accountService;

    public CreateAccountCommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        System.out.println("Enter the user id for which to create an account:");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        accountService.createAccount(id);
        sc.close();

    }
}
