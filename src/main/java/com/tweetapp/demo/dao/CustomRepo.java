package com.tweetapp.demo.dao;

import com.mongodb.client.result.UpdateResult;
import com.tweetapp.demo.models.Reply;

import java.util.List;

public interface CustomRepo {

        UpdateResult updateUserPassword(String email, String password);
        UpdateResult updateTweetRly(Long tweetId, List<Reply> rlyList);
        UpdateResult updateTweetLike(Long tweetId, long l);
        UpdateResult updateTweetCont(Long tweetId, String tweetCont, String hashTag);
}
