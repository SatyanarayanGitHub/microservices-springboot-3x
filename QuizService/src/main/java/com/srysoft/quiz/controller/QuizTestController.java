package com.srysoft.quiz.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz-test")
public class QuizTestController {
    @GetMapping
    public String quizTest() {
        return "This is quiz test controller";
    }
}
