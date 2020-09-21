package com.chrisboer.restassignment.repositories;

import com.chrisboer.restassignment.models.Account;
import com.chrisboer.restassignment.services.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTests {

    @Mock
    AccountRepository mockAccountRepository;

    @InjectMocks
    AccountService accountService;

    @Test
    public void testGetAllAccountsCallsRepo() {
        // Arrange
        List<Account> response = Arrays.asList(
                new Account("asdf1"),
                new Account("asdf2"),
                new Account("asdf3"));

        Mockito.when(mockAccountRepository.findAll()).thenReturn(response);

        // Act
        List<Account> result = accountService.getAllAccounts();

        // Assert
        assertThat(result).isNotEmpty();
        assertThat(result).isEqualTo(response);
        Mockito.verify(mockAccountRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testGetAllAccountsWithPagination() {
        // Arrange
        List<Account> accountList = Arrays.asList(
                new Account("asdf1"),
                new Account("asdf2"),
                new Account("asdf3"),
                new Account("asdf4"),
                new Account("asdf5"),
                new Account("asdf6"),
                new Account("asdf7"),
                new Account("asdf8"),
                new Account("asdf9"),
                new Account("asdf10"));

        int page = 0;
        int pageSize = 3;
        String sortDir = "ASC";
        String sortBy = "iban";
        Pageable pageRequest = PageRequest.of(page, pageSize, Sort.Direction.fromString(sortDir), sortBy);
        Page<Account> expectedPage = new PageImpl<>(accountList, pageRequest, accountList.size());

        Page<Account> response = new PageImpl<Account>(accountList, pageRequest, accountList.size());
        Mockito.when(mockAccountRepository.findAll(pageRequest)).thenReturn(response);

        // Act
        Page<Account> result = accountService.getAllAccounts(page, pageSize, "ASC", "iban");

        // Assert
        assertThat(result).isNotEmpty();
        assertThat(result.getContent()).hasSize(pageSize);
        assertThat(result.getContent()).isEqualTo(expectedPage.getContent());
        Mockito.verify(mockAccountRepository, Mockito.times(1)).findAll(pageRequest);
    }
}
