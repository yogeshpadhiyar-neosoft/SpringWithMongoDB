package com.neosoft.springMongo.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends RuntimeException{
    private HttpStatus httpStatus;
    private String errorMessage;
    private List<String> errors;

    public CustomException(HttpStatus httpStatus ,  String errorMessage){
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }
}
