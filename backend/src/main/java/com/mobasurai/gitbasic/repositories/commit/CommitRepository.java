package com.mobasurai.gitbasic.repositories.commit;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommitRepository extends JpaRepository<Commit, Long> {
}
