package com.QuizApp;

import com.QuizApp.dto.QuestionDto;
import com.QuizApp.services.QuestionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizAppApplication{
	public static void main(String[] args) {
		SpringApplication.run(QuizAppApplication.class, args);
	}



}

