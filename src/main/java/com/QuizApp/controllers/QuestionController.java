package com.QuizApp.controllers;

import com.QuizApp.dto.QuestionDto;
import com.QuizApp.services.QuestionServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    Logger logger= LoggerFactory.getLogger(QuestionController.class);
    @Autowired
    private  QuestionServices questionServices;

    @PostMapping
    ResponseEntity<QuestionDto> createQuestion(@RequestBody QuestionDto questionDto){
        return questionServices.createQuestion(questionDto);
    }

    @PutMapping("/{questionNO}")
    ResponseEntity<QuestionDto> updateQuestion(@RequestBody QuestionDto questionDto, @PathVariable("questionNO") Integer questionNO){
        return (questionServices.update(questionDto,questionNO));
    }
    @GetMapping("{questionNo}")
  ResponseEntity<QuestionDto> getSingleQuestion(@PathVariable("questionNo") Integer questionNo){
             logger.info("question number is :{}",questionNo);
             return questionServices.getSingleQuestion(questionNo);
    }
    @GetMapping
    ResponseEntity<List<QuestionDto>>getAllQuestions(){
        return questionServices.getAllQuestion();
    }
    @GetMapping("/search/{category}")
    ResponseEntity<List<QuestionDto>>searchByCategory(@PathVariable("category") String category){
        return questionServices.searchByCategory(category);
    }
    @DeleteMapping("/{questionNo}")
    ResponseEntity<String> deleteQuestion(@PathVariable("questionNo") Integer questionNo){
        return questionServices.deleteById(questionNo);
    }
}
