package com.tweetapp.demo.dao;

import com.mongodb.client.result.UpdateResult;
import com.tweetapp.demo.models.Reply;
import com.tweetapp.demo.models.Tweet;
import com.tweetapp.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomRepoImpl implements CustomRepo{

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public UpdateResult updateUserPassword(String email, String password) {

            Query query = new Query(Criteria.where("email").is(email));
            Update update = new Update();
            update.set("password", password);
            System.out.println("in update");
            UpdateResult result = mongoTemplate.updateFirst(query, update, User.class);
            return result;

            /*if(result == null)
                System.out.println("No documents updated");
            else
                System.out.println(result.getModifiedCount() + " document(s) updated..");*/

    }

    @Override
    public UpdateResult updateTweetRly(Long tweetId, List<Reply> rlyList) {
        Query query = new Query(Criteria.where("tweetId").is(tweetId));
        Update update = new Update();
        update.set("reply", rlyList);
        UpdateResult result = mongoTemplate.updateFirst(query, update, Tweet.class);
        return result;
    }

    @Override
    public UpdateResult updateTweetLike(Long tweetId, long l) {
        System.out.println(tweetId);
        Query query = new Query(Criteria.where("tweetId").is(tweetId));
        Update update = new Update();
        update.set("like", l);
        UpdateResult result = mongoTemplate.updateFirst(query, update, Tweet.class);
        if(result == null){
            System.out.println("not updated");
        }
        return result;
    }

    @Override
    public UpdateResult updateTweetCont(Long tweetId, String tweetCont, String hashTag) {
        Query query = new Query(Criteria.where("tweetId").is(tweetId));
        Update update = new Update();
        update.set("tweetContent", tweetCont);
        update.set("hashTag", hashTag);
        UpdateResult result = mongoTemplate.updateFirst(query, update, Tweet.class);
        return result;
    }

}
