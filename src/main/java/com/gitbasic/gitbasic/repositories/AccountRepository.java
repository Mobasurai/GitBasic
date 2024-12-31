package com.gitbasic.gitbasic.repositories;

import org.springframework.data.repository.CrudRepository;


public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByUsername(String username);
    Account findByEmail(String email);
    Account findById(long id);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
