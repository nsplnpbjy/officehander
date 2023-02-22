package com.comradegenrr.officehander.officehander.config;

import java.io.IOException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvicor {

    @ExceptionHandler(IOException.class)
    public void ioexceptionHandler(IOException e){
        return;
    }

    @ExceptionHandler(InterruptedException.class)
    public void interruptedExceptionHandler(InterruptedException e){
        return;
    }
    
}
