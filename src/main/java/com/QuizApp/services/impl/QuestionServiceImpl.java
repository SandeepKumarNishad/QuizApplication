package com.QuizApp.services.impl;

import ch.qos.logback.core.model.Model;
import com.QuizApp.dto.QuestionDto;
import com.QuizApp.entities.Questions;
import com.QuizApp.exceptions.ResouceNotFoundException;
import com.QuizApp.repositiories.QuestionRepository;
import com.QuizApp.services.QuestionServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionServices {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public ResponseEntity<QuestionDto> createQuestion(QuestionDto questionDto) {
       Questions questions= mapper.map(questionDto, Questions.class);
       Questions questions1=questionRepository.save(questions);
       QuestionDto questionDto1 =mapper.map(questions1, QuestionDto.class);
        return new ResponseEntity<>(questionDto1,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<QuestionDto> update(QuestionDto questionDto, Integer questionNo) {
          Questions question=questionRepository.findById(questionNo).orElseThrow(()->new ResouceNotFoundException("resouce Not found"));
          question.setQuestionTitle(questionDto.getQuestionTitle());
          question.setOption1(questionDto.getOption1());
          question.setOption2(questionDto.getOption2());
          question.setOption3(questionDto.getOption3());
          question.setOption4(questionDto.getOption4());
          question.setRightAnswer(questionDto.getRightAnswer());
          question.setDifficultyLevel(questionDto.getDifficultyLevel());
          question.setCategory(questionDto.getCategory());
          Questions question1=questionRepository.save(question);
         return new ResponseEntity<>(mapper.map(question1,QuestionDto.class),HttpStatus.OK);
    }
    @Override
    public ResponseEntity<List<QuestionDto>> getAllQuestion() {
           List<Questions> questions=questionRepository.findAll();
           List<QuestionDto> questionDtoList=new ArrayList<QuestionDto>();
        for (Questions question1:questions) {
                QuestionDto questionDto=mapper.map(question1, QuestionDto.class);
                questionDtoList.add(questionDto);
             }
        return new ResponseEntity<>(questionDtoList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<QuestionDto> getSingleQuestion(Integer questionNO) {
        Questions singlequestion=questionRepository.findById(questionNO).orElseThrow(()->new ResouceNotFoundException("resouce is not available"));
        return new ResponseEntity<>(mapper.map(singlequestion,QuestionDto.class),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<QuestionDto>> searchByCategory(String category) {
        List<Questions> questions=questionRepository.findByCategory(category);
        List<QuestionDto> questionDtoList=new ArrayList<QuestionDto>();
        for (Questions question1:questions) {
            QuestionDto questionDto=mapper.map(question1, QuestionDto.class);
            questionDtoList.add(questionDto);
        }
        return new ResponseEntity<>(questionDtoList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteById(Integer questionNo) {
        questionRepository.deleteById(questionNo);
        return new ResponseEntity<>("Question deleted successfully",HttpStatus.OK);
    }



}
