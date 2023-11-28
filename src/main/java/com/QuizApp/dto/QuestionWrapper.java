package com.QuizApp.dto;

import lombok.Data;

@Data
public class QuestionWrapper {
    private Integer questionNo;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public QuestionWrapper(Integer questionNo, String questionTitle, String option1, String option2, String option3, String option4) {
        this.questionNo = questionNo;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
}
