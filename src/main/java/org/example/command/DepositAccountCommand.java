package org.example.command;

import org.example.service.AccountService;

import java.util.Scanner;

public class DepositAccountCommand implements Command{

    private final AccountService accountService;

    public DepositAccountCommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        System.out.println("Enter account ID:");
        Scanner sc = new Scanner(System.in);
        int accId = sc.nextInt();
        System.out.println("Enter amount to deposit:");
        double amount = sc.nextDouble();
        accountService.depositAccount(accId, amount);
        sc.close();
    }
}
