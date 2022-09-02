package com.tweetapp.demo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Error {

    private int status;
    private String message;
    private String path;
    private Long timestamp;
}
