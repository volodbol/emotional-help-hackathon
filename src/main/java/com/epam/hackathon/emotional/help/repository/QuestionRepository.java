package com.epam.hackathon.emotional.help.repository;

import com.epam.hackathon.emotional.help.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
