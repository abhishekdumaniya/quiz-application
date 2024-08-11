package com.abhishek.controller;

import com.abhishek.model.Question;
import com.abhishek.service.QuizService;
import com.sun.jdi.event.StepEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ,
                                             @RequestParam String title){
        return quizService.createQuiz(category, numQ, title);
    }

//    @GetMapping("get/{id}")
//    public ResponseEntity<List<Question>> getQuiz(@PathVariable Integer id){
//        return quizService
//    }

}
