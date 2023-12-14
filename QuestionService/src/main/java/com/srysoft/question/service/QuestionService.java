package com.srysoft.question.service;

import com.srysoft.question.entity.Question;

import java.util.List;

public interface QuestionService {
    Question create(Question question);

    List<Question> get();

    Question getOne(Long id);

    List<Question> getQuestionsOfQuiz(Long quizId);
}
