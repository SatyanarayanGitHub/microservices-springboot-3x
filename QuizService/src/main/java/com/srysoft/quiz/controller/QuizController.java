package com.srysoft.quiz.controller;

import com.srysoft.quiz.entity.Quiz;
import com.srysoft.quiz.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    //    create
    @PostMapping
    public Quiz create(@RequestBody Quiz quiz) {
        return quizService.add(quiz);
    }

    // get all
    @GetMapping
    public List<Quiz> get() {
        return quizService.get();
    }

    // get quiz by Id
    @GetMapping("/{id}")
    public Quiz getOne(@PathVariable Long id) {
        return quizService.get(id);
    }


}
