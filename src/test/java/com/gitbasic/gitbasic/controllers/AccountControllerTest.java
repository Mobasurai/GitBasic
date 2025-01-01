package com.gitbasic.gitbasic.controllers;

import com.gitbasic.gitbasic.controllers.dto.SignUpRequestDto;
import com.gitbasic.gitbasic.controllers.dto.SignInRequestDto;
import com.gitbasic.gitbasic.repositories.Account;
import com.gitbasic.gitbasic.repositories.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AccountControllerTest {
    private AccountRepository accountRepository;
    private AccountController accountController;

    @BeforeEach
    void setUp() {
        accountRepository = mock(AccountRepository.class);
        accountController = new AccountController(accountRepository);
    }

    // Tests for createAccount

    @Test
    void createAccount_shouldReturnBadRequest_forInvalidInput() {
        SignUpRequestDto invalidRequest = new SignUpRequestDto(null, "", "", "");

        HttpStatus response = accountController.createAccount(invalidRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response);
        verifyNoInteractions(accountRepository);
    }

    @Test
    void createAccount_shouldReturnConflict_ifUsernameOrEmailExists() {
        SignUpRequestDto validRequest = new SignUpRequestDto(null, "user1", "user1@example.com", "password");
        when(accountRepository.existsByUsername("user1")).thenReturn(true);

        HttpStatus response = accountController.createAccount(validRequest);

        assertEquals(HttpStatus.CONFLICT, response);
        verify(accountRepository, times(1)).existsByUsername("user1");
    }

    @Test
    void createAccount_shouldReturnCreated_forValidInputAndNoConflicts() {
        SignUpRequestDto validRequest = new SignUpRequestDto(null, "user1", "user1@example.com", "password");
        when(accountRepository.existsByUsername("user1")).thenReturn(false);
        when(accountRepository.existsByEmail("user1@example.com")).thenReturn(false);

        HttpStatus response = accountController.createAccount(validRequest);

        assertEquals(HttpStatus.CREATED, response);
        verify(accountRepository, times(1)).existsByUsername("user1");
        verify(accountRepository, times(1)).existsByEmail("user1@example.com");
        verify(accountRepository, times(1)).save(any(Account.class));
    }

    // Tests for signIn

    @Test
    void signIn_shouldReturnBadRequest_forInvalidInput() {
        SignInRequestDto invalidRequest = new SignInRequestDto("", "");

        HttpStatus response = accountController.signIn(invalidRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response);
        verifyNoInteractions(accountRepository);
    }

    @Test
    void signIn_shouldReturnNotFound_ifUsernameDoesNotExist() {
        SignInRequestDto validRequest = new SignInRequestDto("user1", "password");
        when(accountRepository.existsByUsername("user1")).thenReturn(false);

        HttpStatus response = accountController.signIn(validRequest);

        assertEquals(HttpStatus.NOT_FOUND, response);
        verify(accountRepository, times(1)).existsByUsername("user1");
    }

    @Test
    void signIn_shouldReturnUnauthorized_ifPasswordIsIncorrect() {
        SignInRequestDto validRequest = new SignInRequestDto("user1", "wrongPassword");
        Account account = new Account("user1", "user1@example.com", "password");
        when(accountRepository.existsByUsername("user1")).thenReturn(true);
        when(accountRepository.findByUsername("user1")).thenReturn(account);

        HttpStatus response = accountController.signIn(validRequest);

        assertEquals(HttpStatus.UNAUTHORIZED, response);
        verify(accountRepository, times(1)).findByUsername("user1");
    }

    @Test
    void signIn_shouldReturnOk_forValidCredentials() {
        SignInRequestDto validRequest = new SignInRequestDto("user1", "password");
        Account account = new Account("user1", "user1@example.com", "password");
        when(accountRepository.existsByUsername("user1")).thenReturn(true);
        when(accountRepository.findByUsername("user1")).thenReturn(account);

        HttpStatus response = accountController.signIn(validRequest);

        assertEquals(HttpStatus.OK, response);
        verify(accountRepository, times(1)).findByUsername("user1");
    }
}