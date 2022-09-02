package com.tweetapp.demo.exceptions;

import org.springframework.validation.BindingResult;

public class ParametersMismatchException extends Exception {
    public ParametersMismatchException(String msg) {
        super(msg);
    }
}
