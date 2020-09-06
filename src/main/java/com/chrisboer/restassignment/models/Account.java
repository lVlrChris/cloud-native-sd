package com.chrisboer.restassignment.models;

import javax.persistence.*;

@Entity
public class Account {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    private String iBAN;
    private double balance;
    private boolean isBlocked;
//    private List<AccountHolder> accountHolders;

    protected Account() {}

    public Account(String iBAN) {
        this.iBAN = iBAN;
//        accountHolders = new ArrayList<AccountHolder>();
    }

    public double addBalance(double amount) {
        return balance += amount;
    }

    public double removeBalance(double amount) {
        return balance -= amount;
    }

//    public boolean addAccountHolder(AccountHolder accountHolder) {
//        return accountHolders.add(accountHolder);
//    }
//
//    public boolean removeAccountHolder(AccountHolder accountHolder) {
//        if (accountHolders.size() > 1) {
//            return accountHolders.remove(accountHolder);
//        }
//
//        return false;
//    }

    public long getId() {
        return id;
    }

    public String getIBAN() {
        return iBAN;
    }

    public void setIBAN(String iBAN) {
        this.iBAN = iBAN;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
