package com.tweetapp.demo.dao;

import com.tweetapp.demo.models.Tweet;
import com.tweetapp.demo.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TweetRepo  extends MongoRepository<Tweet, Long> {

    @Query("{tweetBy:'?0'}")
    List<Tweet> findAllByTweetBy(String username);

    Tweet findBytweetId(Long id);
}
