package com.epam.hackathon.emotional.help.repository;

import com.epam.hackathon.emotional.help.model.Advice;
import com.epam.hackathon.emotional.help.model.AnswerGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdviceRepository extends JpaRepository<Advice, Long> {

    Optional<Advice> findAdviceByAnswerGroup(AnswerGroup answerGroup);

}
