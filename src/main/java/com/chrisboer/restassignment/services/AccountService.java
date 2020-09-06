package com.chrisboer.restassignment.services;

import com.chrisboer.restassignment.models.Account;
import com.chrisboer.restassignment.repositories.AccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

//    private List<Account> accounts;
    private final AccountRepository accountRepo;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepo = accountRepository;
    }

    public List<Account> getAllAccounts() {
        List<Account> result = new ArrayList<Account>();
        accountRepo.findAll().forEach(result::add);
        return result;
    }

    public Page<Account> getAllAccounts(int page, int size, String sortDir, String sort) {
        PageRequest pageReq = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);

        return accountRepo.findAll(pageReq);
    }
    
    public Account getAccount(long id) {
        return accountRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Account createAccount(Account newAccount) {
        return accountRepo.save(newAccount);
    }

    public Account updateAccount(Account updatedAccount, long id) {
        Account toUpdate = accountRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        toUpdate.setIBAN(updatedAccount.getIBAN());
        toUpdate.setBalance(updatedAccount.getBalance());
        toUpdate.setBlocked(updatedAccount.isBlocked());
        return accountRepo.save(toUpdate);
    }

    public void deleteAccount(long id) {
        accountRepo.deleteById(id);
    }
}
