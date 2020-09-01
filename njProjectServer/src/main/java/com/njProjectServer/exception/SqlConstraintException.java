package com.njProjectServer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "")
public class SqlConstraintException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public SqlConstraintException(String message) {
        super(message);
    }
}
