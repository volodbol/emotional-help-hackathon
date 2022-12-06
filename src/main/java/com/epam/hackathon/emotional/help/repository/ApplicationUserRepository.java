package com.epam.hackathon.emotional.help.repository;

import com.epam.hackathon.emotional.help.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
