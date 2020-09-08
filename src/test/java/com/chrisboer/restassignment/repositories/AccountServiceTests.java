package com.chrisboer.restassignment.repositories;

import com.chrisboer.restassignment.models.Account;
import com.chrisboer.restassignment.services.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

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
        accountService.getAllAccounts();

        // Assert
        Mockito.verify(mockAccountRepository, Mockito.times(1)).findAll();
    }
}
