package com.chrisboer.restassignment.services;

import com.chrisboer.restassignment.models.AccountHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountHolderService {

    private List<AccountHolder> accountHolders;

    public AccountHolderService() {
        accountHolders = new ArrayList<AccountHolder>();
    }

    public List<AccountHolder> getAllAccountHolders() {
        return accountHolders;
    }

    public AccountHolder getAccountHolder(long id) {
        for (AccountHolder accountHolder : accountHolders) {
            if (accountHolder.getId() == id) {
                return accountHolder;
            }
        }
        return null;
    }

    public AccountHolder createAccountHolder(AccountHolder newAccountHolder) {
        if (accountHolders.add(newAccountHolder)) {
            return newAccountHolder;
        }
        return null;
    }

    public boolean deleteAccountHolder(long id) {
        for (AccountHolder accountHolder : accountHolders) {
            if (accountHolder.getId() == id) {
                accountHolders.remove(accountHolders.indexOf(accountHolder));
                return true;
            }
        }
        return false;
    }
}
