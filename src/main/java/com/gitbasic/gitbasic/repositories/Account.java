package com.gitbasic.gitbasic.repositories;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
public class Account {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    private String username;
    @Getter
    private String email;
    @Getter
    private String password;

    protected Account() {}
    public Account(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
