package com.chrisboer.restassignment.repositories;

import com.chrisboer.restassignment.models.AccountHolder;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountHolderRepository extends PagingAndSortingRepository<AccountHolder, Long> {
}
