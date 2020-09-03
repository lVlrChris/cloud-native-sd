package com.chrisboer.restassignment.controllers;

import com.chrisboer.restassignment.models.Account;
import com.chrisboer.restassignment.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public List<Account> getAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable("id")long id) {
        return accountService.getAccount(id);
    }

    @PostMapping("/")
    public Account createAccount(@RequestBody Account newAccount) {
        return accountService.createAccount(newAccount);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@RequestBody Account updatedAccount, @PathVariable("id")long id) {
        return accountService.updateAccount(updatedAccount, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable("id")long id) {
        if (accountService.deleteAccount(id)) {
            return ResponseEntity.ok("Account deleted.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
