package com.chrisboer.restassignment.services;

import com.chrisboer.restassignment.models.AccountHolder;
import com.chrisboer.restassignment.repositories.AccountHolderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class AccountHolderServiceTests {

    @Mock
    AccountHolderRepository mockRepo;

    @InjectMocks
    AccountHolderService service;

    @Test
    public void testGetAllAccountHolders() {
        // Arrange
        List<AccountHolder> response = Arrays.asList(
                new AccountHolder("asdf1"),
                new AccountHolder("asdf2"),
                new AccountHolder("asdf3"));

        Mockito.when(mockRepo.findAll()).thenReturn(response);

        // Act
        List<AccountHolder> result = service.getAllAccountHolders();

        // Assert
        assertThat(result).isNotEmpty();
        assertThat(result).isEqualTo(response);
        Mockito.verify(mockRepo, Mockito.times(1)).findAll();
    }

    @Test
    public void testCreateCorrectAccountHolder() {
        // Arrange
        AccountHolder correctAccountHolder = new AccountHolder("accountname");

        Mockito.when(mockRepo.save(Mockito.any(AccountHolder.class))).thenReturn(correctAccountHolder);

        // Act
        AccountHolder result = service.createAccountHolder(correctAccountHolder);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(correctAccountHolder);
        Mockito.verify(mockRepo, Mockito.times(1)).save(correctAccountHolder);
    }

    @Test
    public void testUpdateAccount() {
        // Arrange
        AccountHolder originalAccountHolder = new AccountHolder("originalname");
        Optional<AccountHolder> optionalObject = Optional.of(originalAccountHolder);

        AccountHolder updatedAccountHolder = new AccountHolder("updatedname");

        Mockito.when(mockRepo.findById(Mockito.anyLong())).thenReturn(optionalObject);
        Mockito.when(mockRepo.save(Mockito.any(AccountHolder.class))).thenAnswer(i -> i.getArguments()[0]);

        // Act
        AccountHolder result = service.updateAccountHolder(updatedAccountHolder, 0);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(updatedAccountHolder);
        Mockito.verify(mockRepo, Mockito.times(1)).save(Mockito.any(AccountHolder.class));
    }

    @Test
    public void testDeleteAccount() {
        // Arrange
        long accountId = 3L;

        // Act
        service.deleteAccountHolder(accountId);

        // Assert
        Mockito.verify(mockRepo, Mockito.times(1)).deleteById(accountId);
    }
}
