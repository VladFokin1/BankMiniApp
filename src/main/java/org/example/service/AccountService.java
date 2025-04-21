package org.example.service;

import org.example.model.Account;
import org.example.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final List<Account> accountList;
    private final UserService userService;
    private final AccountProperties accountProperties;

    public AccountService(UserService userService, AccountProperties accountProperties) {
        this.accountList = new ArrayList<>();
        this.userService = userService;
        this.accountProperties = accountProperties;

    }

    public void createAccount(int userId) {
        Account account = new Account(userId);
        accountList.add(account);
        userService.getUserById(userId).getAccountList().add(account);
    }

    public void depositAccount(int accountId, double amount) {
        Account acc = getAccountById(accountId);
        acc.addMoney(amount);
    }

    public void withdrawAccount(int accountId, double amount) {
        Account acc = getAccountById(accountId);
        acc.removeMoney(amount);
    }

    public void transferMoney(int senderId, int targetId, double moneyAmount) {
        Account accSender = getAccountById(senderId);
        Account accTarget = getAccountById(targetId);
        //if разные владельцы
        accSender.removeMoney(moneyAmount + moneyAmount*accountProperties.getTransferCommission());
        //else перевод без коммиссии
        //endif
        accTarget.addMoney(moneyAmount);
    }

    public void closeAccount() {

    }


    private Account getAccountById(int accountId) {
        return accountList.stream()
                .filter(user -> user.getId() == accountId)
                .findFirst().get();
    }
}
