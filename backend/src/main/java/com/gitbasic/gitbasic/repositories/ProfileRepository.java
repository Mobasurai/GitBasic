package com.gitbasic.gitbasic.repositories;

import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
    Iterable<Profile> findAllByName(String name);
    Iterable<Profile> findAllByOrganization(String organization);
    Iterable<Profile> findAllByLocation(String location);
}
