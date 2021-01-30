package com.dermacon.workshop.data;

import com.dermacon.workshop.data.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    AppUser findByUserId(long id);
    AppUser findByUsername(String username);
}
