package com.srysoft.quiz.service;

import com.srysoft.quiz.entity.Quiz;
import com.srysoft.quiz.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz get(Long id) {
        return quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found by given id : " + id));
    }
}
