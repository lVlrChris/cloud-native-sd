package com.chrisboer.restassignment.services;

import com.chrisboer.restassignment.models.Account;
import com.chrisboer.restassignment.repositories.AccountRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    @Disabled
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

    @Test
    public void testCreateCorrectAccount() {
        // Arrange
        Account correctAccount = new Account("iban123");

        Mockito.when(mockAccountRepository.save(Mockito.any(Account.class))).thenReturn(correctAccount);

        // Act
        Account result = accountService.createAccount(correctAccount);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(correctAccount);
        Mockito.verify(mockAccountRepository, Mockito.times(1)).save(correctAccount);
    }

    @Test
    public void testUpdateAccount() {
        // Arrange
        Account originalAccount = new Account("originaliban");
        originalAccount.setBalance(3.5d);
        Optional<Account> optionalObject = Optional.of(originalAccount);

        Account updatedAccount = new Account("updatediban");
        updatedAccount.setBalance(5.7d);
        updatedAccount.setBlocked(true);

        Mockito.when(mockAccountRepository.findById(Mockito.anyLong())).thenReturn(optionalObject);
        Mockito.when(mockAccountRepository.save(Mockito.any(Account.class))).thenAnswer(i -> i.getArguments()[0]);
        // Act
        Account result = accountService.updateAccount(updatedAccount, 0);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(updatedAccount);
        Mockito.verify(mockAccountRepository, Mockito.times(1)).save(Mockito.any(Account.class));
    }

    @Test
    public void testDeleteAccount() {
        // Arrange
        long accountId = 3L;

        // Act
        accountService.deleteAccount(accountId);

        // Assert
        Mockito.verify(mockAccountRepository, Mockito.times(1)).deleteById(accountId);
    }
}
