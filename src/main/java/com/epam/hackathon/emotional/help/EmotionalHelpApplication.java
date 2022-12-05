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
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "Emotional Help API",
        version = "1.0",
        description = "Emotional Help Project Api Information"))
public class EmotionalHelpApplication {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(EmotionalHelpApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(
            QuestionnaireRepository questionnaireRepository,
            QuestionRepository questionRepository,
            AnswerRepository answerRepository) {
        List<Answer> answers = answers();
        answerRepository.saveAll(answers);
        List<Question> questions = questions(answerRepository);
        questionRepository.saveAll(questions);
        return (String[] args) -> questionnaireRepository.save(
                Questionnaire.builder()
                        .title("Emotional map")
                        .questions(questions)
                        .build()
        );
    }

    private static List<Question> questions(AnswerRepository answerRepository) {
        return List.of(
                Question.builder()
                        .questionText("Question 1")
                        .answers(answerRepository.findAll().subList(0, 2))
                        .build(),
                Question.builder()
                        .questionText("Question 2")
                        .answers(answerRepository.findAll().subList(2, 4))
                        .build()
        );
    }

    private static List<Answer> answers() {
        return List.of(
                Answer.builder()
                        .value("Ok")
                        .mark(3)
                        .answerGroup(AnswerGroup.HAPPY)
                        .build(),
                Answer.builder()
                        .value("Bad")
                        .mark(4)
                        .answerGroup(AnswerGroup.SADNESS)
                        .build(),
                Answer.builder()
                        .value("Fine")
                        .mark(3)
                        .answerGroup(AnswerGroup.JOY)
                        .build(),
                Answer.builder()
                        .value("No hope")
                        .mark(4)
                        .answerGroup(AnswerGroup.SADNESS)
                        .build()
        );
    }


}
