package com.roleManagement.rolebasedManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    // handle specific Duplicate data exception
    @ExceptionHandler(DuplicateResource.class)
    public ResponseEntity<?>handleDuplicateResource(DuplicateResource exception, WebRequest request){
        ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }
//    Handling if data is not matching during
//    @ExceptionHandler(DuplicateResource.class)
//    public ResponseEntity<?>handleDuplicateResource(DuplicateResource exception, WebRequest request){
//        ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false));
//        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
//    }
//    Handle global exception
@ExceptionHandler(Exception.class)
public ResponseEntity<?>handleException(Exception exception, WebRequest request){
    ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false));
    return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
}
}
