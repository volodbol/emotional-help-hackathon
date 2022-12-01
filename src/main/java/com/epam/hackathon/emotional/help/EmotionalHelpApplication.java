package com.epam.hackathon.emotional.help;

import com.epam.hackathon.emotional.help.model.Answer;
import com.epam.hackathon.emotional.help.model.AnswerGroup;
import com.epam.hackathon.emotional.help.model.Question;
import com.epam.hackathon.emotional.help.model.Questionnaire;
import com.epam.hackathon.emotional.help.repository.AnswerRepository;
import com.epam.hackathon.emotional.help.repository.QuestionRepository;
import com.epam.hackathon.emotional.help.repository.QuestionnaireRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "Emotional Help API",
        version = "1.0",
        description = "Emotional Help Project Api Information"))
public class EmotionalHelpApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmotionalHelpApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(
            QuestionnaireRepository questionnaireRepository,
            QuestionRepository questionRepository,
            AnswerRepository answerRepository) {
        return (String[] args) ->  {
            Questionnaire questionnaire = questionnaireRepository
                    .save(Questionnaire.builder().title("Emotional map").build());
            List<Question> questions = questions(questionnaire);
            questionRepository.saveAll(questions);
            List<Answer> answers = answers(questionRepository);
            answerRepository.saveAll(answers);
        };
    }

    private static List<Question> questions(Questionnaire questionnaire) {
        return List.of(
                Question.builder()
                        .questionText("Question 1")
                        .questionnaire(questionnaire)
                        .build(),
                Question.builder()
                        .questionText("Question 2")
                        .questionnaire(questionnaire)
                        .build()
        );
    }

    private static List<Answer> answers(QuestionRepository questionRepository) {
        return List.of(
                Answer.builder()
                        .value("Ok")
                        .mark(3)
                        .question(questionRepository.getReferenceById(1L))
                        .answerGroup(AnswerGroup.HAPPY)
                        .build(),
                Answer.builder()
                        .value("Bad")
                        .mark(4)
                        .question(questionRepository.getReferenceById(1L))
                        .answerGroup(AnswerGroup.SADNESS)
                        .build(),
                Answer.builder()
                        .value("Fine")
                        .mark(3)
                        .question(questionRepository.getReferenceById(2L))
                        .answerGroup(AnswerGroup.JOY)
                        .build(),
                Answer.builder()
                        .value("No hope")
                        .mark(4)
                        .question(questionRepository.getReferenceById(2L))
                        .answerGroup(AnswerGroup.SADNESS)
                        .build()
        );
    }


}
