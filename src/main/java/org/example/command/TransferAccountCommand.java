package org.example.command;

import org.example.service.AccountService;

import java.util.Scanner;

public class TransferAccountCommand implements Command{

    private final AccountService accountService;

    public TransferAccountCommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        System.out.println("Enter sender account ID:");
        Scanner sc = new Scanner(System.in);
        int senderID = sc.nextInt();
        System.out.println("Enter target account ID:");
        int targetID = sc.nextInt();
        System.out.println("Enter amount to transfer:");
        double amount = sc.nextDouble();
        accountService.transferMoney(senderID, targetID, amount);
        sc.close();
    }
}
