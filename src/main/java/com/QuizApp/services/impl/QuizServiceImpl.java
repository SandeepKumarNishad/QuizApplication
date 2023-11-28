package com.QuizApp.services.impl;

import com.QuizApp.dto.QuestionWrapper;
import com.QuizApp.dto.UserAnswer;
import com.QuizApp.entities.Questions;
import com.QuizApp.entities.Quiz;
import com.QuizApp.exceptions.ResouceNotFoundException;
import com.QuizApp.repositiories.QuestionRepository;
import com.QuizApp.repositiories.QuizRepository;
import com.QuizApp.services.QuizService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuizRepository quizRepository;
    @Override
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Questions> questions=questionRepository.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsList(questions);
        quizRepository.save(quiz);
        return new ResponseEntity<>("quiz is created successfully", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quizs=quizRepository.findById(id);
        List<Questions> questions=quizs.get().getQuestionsList();
        List<QuestionWrapper> questionWrappers=new ArrayList<>();
        for (Questions questions1:questions) {
            QuestionWrapper qr=new QuestionWrapper(questions1.getQuestionNo(),questions1.getQuestionTitle(),questions1.getOption1(),questions1.getOption2(),questions1.getOption3(),questions1.getOption4());
            questionWrappers.add(qr);
        }
        return new ResponseEntity<>(questionWrappers,HttpStatus.OK);
    }
    //calculate

public ResponseEntity<Integer> calculateResult(Integer id,List<UserAnswer> userAnswers){
    Optional<Quiz> quizs=quizRepository.findById(id);
    List<Questions> questions=quizs.get().getQuestionsList();
    int right=0;
    int i=0;
    for (UserAnswer userAnswer:userAnswers) {
        if(userAnswer.getUserRight().equals(questions.get(i).getRightAnswer()))
        {
            right++;
        }
        i++;
    }
    return new ResponseEntity<>(right,HttpStatus.OK);

}




























}
