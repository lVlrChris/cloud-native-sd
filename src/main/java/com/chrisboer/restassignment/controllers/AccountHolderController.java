package com.chrisboer.restassignment.controllers;

import com.chrisboer.restassignment.models.AccountHolder;
import com.chrisboer.restassignment.services.AccountHolderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/accountholders")
public class AccountHolderController {

    private final AccountHolderService accountHolderService;

    public AccountHolderController(AccountHolderService accountHolderService) {
        this.accountHolderService = accountHolderService;
    }

    @GetMapping("")
    public ResponseEntity<List<AccountHolder>> getAccountHolders() {
        return ResponseEntity.ok(accountHolderService.getAllAccountHolders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountHolder> getAccountHolderById(@PathVariable("id")long id) {
        return ResponseEntity.ok(accountHolderService.getAccountHolder(id));
    }

    @PostMapping("")
    public ResponseEntity<AccountHolder> createAccountHolder(@RequestBody AccountHolder newAccountHolder) {
        return ResponseEntity.ok(accountHolderService.createAccountHolder(newAccountHolder));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletedAccount(@PathVariable("id")long id) {
        if (accountHolderService.deleteAccountHolder(id)) {
            return ResponseEntity.ok("Account holder deleted.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
