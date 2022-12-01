package com.epam.hackathon.emotional.help.controller;

import com.epam.hackathon.emotional.help.dto.QuestionnaireDto;
import com.epam.hackathon.emotional.help.exception.QuestionnaireNotFoundException;
import com.epam.hackathon.emotional.help.model.Questionnaire;
import com.epam.hackathon.emotional.help.service.QuestionnaireService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "questionnaires")
@RequiredArgsConstructor
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;

    private final ModelMapper mapper;

    @GetMapping
    public QuestionnaireDto findQuestionnaire(@RequestParam(name = "title") String title) {
       Questionnaire questionnaire = questionnaireService.findQuestionnaireByTitle(title)
                .orElseThrow(
                        () -> new QuestionnaireNotFoundException("Questionnaire with title - " + title + " not found"));
        return mapper.map(questionnaire, QuestionnaireDto.class);
    }

}
