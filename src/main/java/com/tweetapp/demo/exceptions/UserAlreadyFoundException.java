package com.tweetapp.demo.exceptions;

public class UserAlreadyFoundException extends RuntimeException {
    public UserAlreadyFoundException(String msg) {
        super(msg);
    }
}
