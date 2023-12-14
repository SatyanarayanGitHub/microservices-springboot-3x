package com.srysoft.quiz.service;

import com.srysoft.quiz.entity.Quiz;

import java.util.List;

public interface QuizService {

    Quiz add(Quiz quiz);

    List<Quiz> get();

    Quiz get(Long id);
}
