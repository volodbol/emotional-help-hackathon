package com.epam.hackathon.emotional.help.repository;

import com.epam.hackathon.emotional.help.model.EmotionalMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmotionalMapRepository extends JpaRepository<EmotionalMap, Long> {
}
