package com.epam.hackathon.emotional.help.service;

import com.epam.hackathon.emotional.help.model.Quiz;
import com.epam.hackathon.emotional.help.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;

    public Quiz findRandomQuiz() {
        return quizRepository.findRandom();
    }

    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }
}
