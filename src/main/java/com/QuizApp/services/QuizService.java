package com.QuizApp.services;

import com.QuizApp.dto.QuestionWrapper;
import com.QuizApp.dto.UserAnswer;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {
    ResponseEntity<String> createQuiz(String category, int numQ, String title);
    ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id);
     ResponseEntity<Integer> calculateResult(Integer id,List<UserAnswer> userAnswer);
}
