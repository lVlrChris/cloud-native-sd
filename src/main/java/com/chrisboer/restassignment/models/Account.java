package com.chrisboer.restassignment.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter @EqualsAndHashCode
public class Account {

    private int id;
    private String iBAN;
    private double balance;
    private ArrayList<AccountHolder> accountHolders;

    public Account(String iBAN, AccountHolder accountHolder) {
        this.iBAN = iBAN;
        this.accountHolders.add(accountHolder);
    }

    public double addBalance(double amount) {
        return balance += amount;
    }

    public double removeBalance(double amount) {
        return balance -= amount;
    }

    public boolean addAccountHolder(AccountHolder accountHolder) {
        return accountHolders.add(accountHolder);
    }

    public boolean removeAccountHolder(AccountHolder accountHolder) {
        if (accountHolders.size() > 1) {
            return accountHolders.remove(accountHolder);
        }

        return false;
    }

}
