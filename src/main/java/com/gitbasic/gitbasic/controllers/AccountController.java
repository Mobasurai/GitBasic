package com.gitbasic.gitbasic.controllers;

import com.gitbasic.gitbasic.controllers.dto.SignUpRequestDto;
import com.gitbasic.gitbasic.controllers.dto.SignInRequestDto;
import com.gitbasic.gitbasic.repositories.Account;
import com.gitbasic.gitbasic.repositories.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @PostMapping("/signup")
    public HttpStatus createAccount(@RequestBody SignUpRequestDto account) {
        if (account.getUsername() == null || account.getUsername().isBlank() ||
                account.getEmail() == null || account.getEmail().isBlank() ||
                account.getPassword() == null || account.getPassword().isBlank()) {
            return HttpStatus.BAD_REQUEST;
        }

        if (accountRepository.existsByUsername(account.getUsername()) || accountRepository.existsByEmail(account.getEmail())) {
            return HttpStatus.CONFLICT;
        }

        accountRepository.save(new Account(account.getUsername(), account.getEmail(), account.getPassword()));
        return HttpStatus.CREATED;
    }

    @PostMapping("/signin")
    public HttpStatus signIn(@RequestBody SignInRequestDto signInRequest) {
        if (signInRequest.getUsername() == null || signInRequest.getUsername().isBlank() ||
                signInRequest.getPassword() == null || signInRequest.getPassword().isBlank()) {
            return HttpStatus.BAD_REQUEST;
        }

        if (!accountRepository.existsByUsername(signInRequest.getUsername())) {
            return HttpStatus.NOT_FOUND;
        }

        Account account = accountRepository.findByUsername(signInRequest.getUsername());
        if (!account.getPassword().equals(signInRequest.getPassword())) {
            return HttpStatus.UNAUTHORIZED;
        }

        return HttpStatus.OK;
    }
}