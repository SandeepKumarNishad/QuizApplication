package com.QuizApp.controllers;

import com.QuizApp.dto.QuestionWrapper;
import com.QuizApp.dto.UserAnswer;
import com.QuizApp.services.QuizService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
private QuizService quizService;
    @PostMapping("/create")
    ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
       return quizService.createQuiz(category,numQ,title);

    }
@GetMapping("/{id}")
ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){

        return quizService.getQuizQuestions(id);

    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<UserAnswer> userAnswers){
        System.out.println("controller entry feel happy");
        return quizService.calculateResult(id,userAnswers);
    }

}
