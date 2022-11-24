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

    public Optional<Questionnaire> findRandomQuestionnaire() {
        return questionnaireRepository.findRandom();
    }

    public Questionnaire addQuestionnaire(Questionnaire questionnaire) {
        return questionnaireRepository.save(questionnaire);
    }

    public boolean updateQuestionnaireById(Questionnaire questionnaire) {
        Optional<Questionnaire> questionnaireFromRepository = questionnaireRepository.findById(questionnaire.getId());
        if (questionnaireFromRepository.isEmpty()) {
            return false;
        }
        Questionnaire questionnaireToUpdate = questionnaireFromRepository.get();
        questionnaireToUpdate.setQuestionAnswersMap(questionnaire.getQuestionAnswersMap());
        questionnaireRepository.save(questionnaireToUpdate);
        return true;
    }

    public void deleteQuestionnaire(Long id) {
        questionnaireRepository.deleteById(id);
    }
}
