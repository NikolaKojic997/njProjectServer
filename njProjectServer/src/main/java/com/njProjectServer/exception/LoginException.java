package com.njProjectServer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "")
public class LoginException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public LoginException(String message) {
        super(message);
    }
}
