package com.srysoft.quiz.service;

import com.srysoft.quiz.client.QuestionClient;
import com.srysoft.quiz.entity.Quiz;
import com.srysoft.quiz.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;

    private QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        //return quizRepository.findAll();

        final List<Quiz> quizList = quizRepository.findAll().stream()
                .map(quiz -> {
                    quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
                    return quiz;
                }).collect(Collectors.toList());
        return quizList;
    }

    @Override
    public Quiz get(Long id) {
        final Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found by given id : " + id));

        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));

        return quiz;
    }
}
