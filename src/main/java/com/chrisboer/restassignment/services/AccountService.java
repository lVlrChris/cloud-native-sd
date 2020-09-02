package com.chrisboer.restassignment.services;

import com.chrisboer.restassignment.models.Account;
import com.chrisboer.restassignment.models.AccountHolder;

import java.util.ArrayList;

public class AccountService {

    private ArrayList<Account> accounts;

    public AccountService() {
        accounts = new ArrayList<Account>();
    }

    public Account[] getAllAccounts() {
        return (Account[]) accounts.toArray();
    }
    
    public Account getAccount(int id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }

        return null;
    }

    public void createAccount(String iBAN, AccountHolder accountHolder) {
        accounts.add(new Account(iBAN, accountHolder));
    }

    
}
