package com.chrisboer.restassignment.services;

import com.chrisboer.restassignment.models.AccountHolder;
import com.chrisboer.restassignment.repositories.AccountHolderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AccountHolderService {

    private final AccountHolderRepository repo;

    public AccountHolderService(AccountHolderRepository accountHolderRepo) {
        this.repo = accountHolderRepo;
    }

    public List<AccountHolder> getAllAccountHolders() {
        return (List<AccountHolder>)repo.findAll();
    }

    public Page<AccountHolder> getAllAccountHolders(int page, int size, String sortDir, String sortBy) {
        Pageable pageReq = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sortBy);

        return repo.findAll(pageReq);
    }

    public AccountHolder getAccountHolder(long id) {
        return repo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public AccountHolder createAccountHolder(AccountHolder newAccountHolder) {
        return repo.save(newAccountHolder);
    }

    public AccountHolder updateAccountHolder(AccountHolder updatedAccountHolder, long id) {
        AccountHolder toUpdate = repo.findById(id).orElseThrow(EntityNotFoundException::new);
        toUpdate.setName(updatedAccountHolder.getName());
        return repo.save(toUpdate);
    }

    public void deleteAccountHolder(long id) {
        repo.deleteById(id);
    }
}
