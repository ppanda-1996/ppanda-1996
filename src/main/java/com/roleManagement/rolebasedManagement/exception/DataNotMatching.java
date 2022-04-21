package com.roleManagement.rolebasedManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class DataNotMatching extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public DataNotMatching(String message) {
        super(message);
    }
}
