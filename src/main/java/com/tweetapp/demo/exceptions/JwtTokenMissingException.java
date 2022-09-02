package com.tweetapp.demo.exceptions;

public class JwtTokenMissingException extends Exception {
    public JwtTokenMissingException(String msg) {
        super(msg);
    }
}
