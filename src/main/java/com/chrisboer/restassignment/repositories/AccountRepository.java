package com.chrisboer.restassignment.repositories;

import com.chrisboer.restassignment.models.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

}
