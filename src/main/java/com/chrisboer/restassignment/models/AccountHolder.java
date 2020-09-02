package com.chrisboer.restassignment.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter @EqualsAndHashCode
public class AccountHolder {

    private int id;
    private String name;
    private ArrayList<Account> accounts;

    public AccountHolder(String name) {
        this.name = name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }
}
