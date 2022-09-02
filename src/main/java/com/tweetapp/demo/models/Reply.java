package com.tweetapp.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor
public class Reply {

    private long id;
    private String by;
    private String rly;
    private LocalDate replyDate;
}
