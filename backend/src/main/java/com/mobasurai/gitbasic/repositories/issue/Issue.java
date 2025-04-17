package com.mobasurai.gitbasic.repositories.issue;

import com.mobasurai.gitbasic.repositories.comment.Comment;
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
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User authorId;

    private String title;
    private String body;
    private String state;

    @OneToMany
    private List<Comment> comments;

    @OneToMany
    private List<PullRequest> pullrequests;

    private Date created;
}