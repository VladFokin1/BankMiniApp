package org.example.model;

import org.example.service.AccountProperties;
import org.springframework.beans.factory.annotation.Autowired;

public class Account {

    private static int maxId = 0;

    private final int id;
    private final int userId;
    private double moneyAmount;

    @Autowired
    private AccountProperties properties;


    public Account(int userId) {
        this.id = ++maxId;
        this.userId = userId;
        this.moneyAmount = properties.getDefaultAmount();
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void addMoney(double amount) {
        this.moneyAmount += amount;
    }
    public void removeMoney(double amount) {
        this.moneyAmount -= amount;
    }
}
