package com.mobasurai.gitbasic.repositories.pullrequest;

import com.mobasurai.gitbasic.repositories.repository.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PullRequestRepository extends JpaRepository<Repository, Long> {
}
