package org.example.command;

import org.example.service.AccountService;

import java.util.Scanner;

public class WithdrawAccountCommand implements Command{

    private final AccountService accountService;

    public WithdrawAccountCommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        System.out.println("Enter account ID:");
        Scanner sc = new Scanner(System.in);
        int accId = sc.nextInt();
        System.out.println("Enter amount to withdraw:");
        double amount = sc.nextDouble();
        accountService.withdrawAccount(accId, amount);
        sc.close();
    }
}
