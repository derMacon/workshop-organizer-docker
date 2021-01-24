package com.dermacon.workshop;

import com.dermacon.workshop.data.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {

}
