package com.mobasurai.gitbasic.repositories.branch;

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
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User authorId;

    private String name;

    @OneToMany
    private List<Commit> commits;

    private Date created;
}
