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

    public Account createAccount(int userId) {
        Account account = new Account(userId, accountProperties.getDefaultAmount());
        accountList.add(account);
        User user = userService.getUserById(userId).orElseThrow(
                () -> new IllegalArgumentException("There is no user with id=%s".formatted(userId))
        );
        user.getAccountList().add(account);
        return account;
    }

    public void depositAccount(int accountId, double amount) {
        Account acc = getAccountById(accountId).orElseThrow(
                () -> new IllegalArgumentException("There is no such account with id=%s".formatted(accountId))
        );
        acc.addMoney(amount);
    }

    public void withdrawAccount(int accountId, double amount) {
        Account acc = getAccountById(accountId).orElseThrow(
                () -> new IllegalArgumentException("There is no such account with id=%s".formatted(accountId))
        );
        if (acc.getMoneyAmount() < amount) {
            throw new IllegalArgumentException("Entered money amount is less than money amount in account");
        } else {
            acc.removeMoney(amount);
        }
    }


    public void transferMoney(int senderId, int targetId, double moneyAmount) {
        Account accSender = getAccountById(senderId).orElseThrow(
                () -> new IllegalArgumentException("There is no such account with id=%s".formatted(senderId))
        );
        Account accTarget = getAccountById(targetId).orElseThrow(
                () -> new IllegalArgumentException("There is no such account with id=%s".formatted(targetId))
        );
        //if разные владельцы
        accSender.removeMoney(moneyAmount + moneyAmount*accountProperties.getTransferCommission());
        //else перевод без коммиссии
        //endif
        accTarget.addMoney(moneyAmount);
    }

    public void closeAccount(int accountId) {
        Account account = getAccountById(accountId).orElseThrow(
                () -> new IllegalArgumentException("There is no such account with id=%s".formatted(accountId))
        );
        User user = userService.getUserById(account.getUserId()).orElseThrow(
                () -> new IllegalArgumentException("There is no user with id=%s".formatted(account.getUserId()))
        );

        //если аккаунт единственный, то отмена
        if (user.getAccountList().size() <= 1) {
            throw new IllegalArgumentException("This is the only one account of " + user);
        }

        //удаление
        user.getAccountList().remove(account);
        accountList.remove(account);
    }


    private Optional<Account> getAccountById(int accountId) {
        return accountList.stream()
                .filter(account -> account.getId() == accountId)
                .findFirst();
    }
}
