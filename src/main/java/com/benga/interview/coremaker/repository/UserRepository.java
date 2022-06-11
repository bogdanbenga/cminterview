package com.benga.interview.coremaker.repository;

import com.benga.interview.coremaker.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * @author Bogdan Benga <bogdanbenga@gmail.com></>
 */
public interface UserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByEmail(String email);
    Optional<AppUser> findByFirstNameAndLastName(String firstName, String lastName);


}
