package com.tweetapp.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
@Document(collection = "Tweet")
public class Tweet {

    @Id
    private Long tweetId;
    private String tweetContent;
    private String hashTag;
    private String tweetBy;
    private Long tweetByCount;
    private LocalDate postDate;
    private Long like;
    private List<Reply> reply;
}
