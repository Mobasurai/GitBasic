package com.mobasurai.gitbasic.repositories.repository;

import com.mobasurai.gitbasic.repositories.fork.Fork;
import com.mobasurai.gitbasic.repositories.issue.Issue;
import com.mobasurai.gitbasic.repositories.pullrequest.PullRequest;
import com.mobasurai.gitbasic.repositories.user.User;
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
public class Repository {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String url;
    private boolean isPrivate;

    @OneToMany
    private List<User> contributors;

    @OneToMany
    private List<Fork> forks;

    @OneToMany
    private List<Issue> issues;

    @OneToMany
    private List<PullRequest> pullrequests;

    private Date created;
}
