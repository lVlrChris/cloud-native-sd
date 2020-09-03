package com.chrisboer.restassignment.services;

import com.chrisboer.restassignment.models.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private List<Account> accounts;

    public AccountService() {
        accounts = new ArrayList<Account>();
    }

    public List<Account> getAllAccounts() {
        return accounts;
    }
    
    public Account getAccount(long id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }

        return null;
    }

    public Account createAccount(Account newAccount) {
        if (accounts.add(newAccount)) {
            return newAccount;
        }

        return null;
    }

    public Account updateAccount(Account updatedAccount, long id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                accounts.set(accounts.indexOf(account), updatedAccount);
                return updatedAccount;
            }
        }

        return null;
    }

    public boolean deleteAccount(long id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                accounts.remove(accounts.indexOf(account));
                return true;
            }
        }
        return false;
    }
}
