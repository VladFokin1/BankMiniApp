package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static int maxId = 0;

    private final int id;
    private final String login;
    private final List<Account> accountList;

    public User(String login) {
        this.id = ++maxId;
        this.login = login;
        accountList = new ArrayList<Account>();
//        accountList.add(new Account(this.id));
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", accountList=" + accountList +
                '}';
    }
}
