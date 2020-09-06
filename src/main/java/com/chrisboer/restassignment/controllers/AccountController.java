package com.chrisboer.restassignment.controllers;

import com.chrisboer.restassignment.models.Account;
import com.chrisboer.restassignment.services.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;
    private final ModelMapper modelMapper;

    public AccountController(AccountService accountService, ModelMapper modelMapper) {
        this.accountService = accountService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("")
    public List<AccountDTO> getAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return accounts.stream()
                .map(account -> modelMapper.map(account, AccountDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AccountDTO getAccountById(@PathVariable("id")long id) {
        return modelMapper.map(accountService.getAccount(id), AccountDTO.class);
    }

    @PostMapping("")
    public AccountDTO createAccount(@RequestBody AccountDTO newAccount) {
        Account result = accountService.createAccount(modelMapper.map(newAccount, Account.class));
        return modelMapper.map(result, AccountDTO.class);
    }

    @PutMapping("/{id}")
    public AccountDTO updateAccount(@RequestBody AccountDTO updatedAccount, @PathVariable("id")long id) {
        Account result = accountService.updateAccount(modelMapper.map(updatedAccount, Account.class), id);
        return modelMapper.map(result, AccountDTO.class);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable("id")long id) {
        accountService.deleteAccount(id);
    }
}
