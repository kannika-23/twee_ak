package com.tweetapp.demo.exceptions;

public class JwtTokenMalformedException extends Exception {

    public JwtTokenMalformedException(String msg) {
        super(msg);
    }
}
