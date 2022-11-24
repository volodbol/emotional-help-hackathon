package com.epam.hackathon.emotional.help.repository;

import com.epam.hackathon.emotional.help.model.EmotionalMap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmotionalMapRepository extends JpaRepository<EmotionalMap, Long> {
    Optional<EmotionalMap> findByApplicationUser_Username(String username);

}
