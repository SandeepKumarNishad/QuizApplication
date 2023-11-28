package com.QuizApp.services;

import com.QuizApp.dto.QuestionDto;
import com.QuizApp.entities.Questions;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionServices {

     ResponseEntity<QuestionDto> createQuestion(QuestionDto questionDto);
     ResponseEntity<QuestionDto> update(QuestionDto questionDto,Integer questionNo);
     ResponseEntity<List<QuestionDto>> getAllQuestion();
     ResponseEntity<QuestionDto> getSingleQuestion(Integer questionNO);
     ResponseEntity<List<QuestionDto>>searchByCategory(String category);
    ResponseEntity<String>deleteById(Integer questionNo);
}
