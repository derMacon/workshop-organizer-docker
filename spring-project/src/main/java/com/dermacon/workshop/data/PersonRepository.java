package com.dermacon.workshop.data;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findByPersonId(long id);
    Person findByUser(AppUser user);
    Person findByEmail(String email);
}
