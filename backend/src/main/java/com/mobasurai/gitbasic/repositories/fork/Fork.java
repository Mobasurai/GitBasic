package com.mobasurai.gitbasic.repositories.fork;

import com.mobasurai.gitbasic.repositories.repository.Repository;
import com.mobasurai.gitbasic.repositories.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Fork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "repository_id")
    private Repository parentRepository;

    private Date created;
}
