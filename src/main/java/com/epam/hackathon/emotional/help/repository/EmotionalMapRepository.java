package com.epam.hackathon.emotional.help.repository;

import com.epam.hackathon.emotional.help.model.ApplicationUser;
import com.epam.hackathon.emotional.help.model.EmotionalMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmotionalMapRepository extends JpaRepository<EmotionalMap, Long> {

    Optional<EmotionalMap> findByAnonymousUUID(String uuid);

    Optional<EmotionalMap> findByApplicationUser(ApplicationUser applicationUser);

}
