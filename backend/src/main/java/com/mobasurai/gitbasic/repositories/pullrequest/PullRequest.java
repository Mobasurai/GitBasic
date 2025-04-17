package com.mobasurai.gitbasic.repositories.pullrequest;

import com.mobasurai.gitbasic.repositories.comment.Comment;
import com.mobasurai.gitbasic.repositories.commit.Commit;
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
public class PullRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User authorId;

    private String title;
    private String body;
    private String branch;

    @OneToMany
    private List<Commit> commits;

    @OneToMany
    private List<Comment> comments;

    private Date created;
}
