package org.example.command;

import org.example.service.AccountService;

import java.util.Scanner;

public class CloseAccountCommand implements Command{

    private final AccountService accountService;

    public CloseAccountCommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        System.out.println("Enter account ID to close:");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        accountService.closeAccount(id);
        sc.close();
    }
}
