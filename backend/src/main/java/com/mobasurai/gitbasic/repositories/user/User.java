package com.mobasurai.gitbasic.repositories.user;

import com.mobasurai.gitbasic.repositories.repository.Repository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String password;
    private String email;
    private String name;
    private String phoneNumber;
    private String profilePicture;
    private String bio;
    private String location;
    private Date created;

    @OneToMany
    private List<Repository> repositories;

    @OneToMany
    private List<User> followers;

    @OneToMany
    private List<User> following;

    @OneToMany
    private List<Repository> stars;
}
