package com.epam.hackathon.emotional.help.service;

import com.epam.hackathon.emotional.help.model.Questionnaire;
import com.epam.hackathon.emotional.help.repository.QuestionnaireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;

    public Optional<Questionnaire> findQuestionnaireByTitle(String title) {
        return questionnaireRepository.findByTitle(title);
    }


}
