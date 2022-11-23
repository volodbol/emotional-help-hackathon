package com.epam.hackathon.emotional.help.repository;

import com.epam.hackathon.emotional.help.model.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswersRepository extends JpaRepository<Answers, Long> {
}
