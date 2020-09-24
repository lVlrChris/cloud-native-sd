package com.chrisboer.restassignment.models;

import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity @EqualsAndHashCode
public class AccountHolder {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
//    private ArrayList<Account> accounts;

    protected AccountHolder() {}

    public AccountHolder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //    public void addAccount(Account account) {
//        accounts.add(account);
//    }
//
//    public void removeAccount(Account account) {
//        accounts.remove(account);
//    }
}
