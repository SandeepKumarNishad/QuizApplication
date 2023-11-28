package com.QuizApp.exceptions;

public class ResouceNotFoundException extends RuntimeException{
    public ResouceNotFoundException(String message){
        super(message);
    }
    public ResouceNotFoundException(){
        super("resouce not found");
    }
}
