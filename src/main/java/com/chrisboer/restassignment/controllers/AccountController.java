package com.chrisboer.restassignment.controllers;

import com.chrisboer.restassignment.models.Account;
import com.chrisboer.restassignment.services.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private AccountService accountService;

    @GetMapping("/accounts")
    public Account[] getAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("account/{id}")
    public Account getAccountById(@PathVariable("id")int id) {
        return accountService.getAccount(id);
    }
}
