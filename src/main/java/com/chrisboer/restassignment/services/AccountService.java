package com.chrisboer.restassignment.services;

import com.chrisboer.restassignment.models.Account;
import com.chrisboer.restassignment.repositories.AccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository repo;

    public AccountService(AccountRepository accountRepository) {
        this.repo = accountRepository;
    }

    public List<Account> getAllAccounts() {
        return (List<Account>) repo.findAll();
    }

    public Page<Account> getAllAccounts(int page, int size, String sortDir, String sortBy) {
        Pageable pageReq = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sortBy);

        return repo.findAll(pageReq);
    }
    
    public Account getAccount(long id) {
        return repo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Account createAccount(Account newAccount) {
        return repo.save(newAccount);
    }

    public Account updateAccount(Account updatedAccount, long id) {
        Account toUpdate = repo.findById(id).orElseThrow(EntityNotFoundException::new);
        toUpdate.setIBAN(updatedAccount.getIBAN());
        toUpdate.setBalance(updatedAccount.getBalance());
        toUpdate.setBlocked(updatedAccount.isBlocked());
        return repo.save(toUpdate);
    }

    public void deleteAccount(long id) {
        repo.deleteById(id);
    }
}
