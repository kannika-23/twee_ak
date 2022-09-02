package com.tweetapp.demo.controllers;

import com.tweetapp.demo.dtomodels.RlyTweet;
import com.tweetapp.demo.dtomodels.TweetDto;
import com.tweetapp.demo.kafka.KafkaProducer;
import com.tweetapp.demo.models.Tweet;
import com.tweetapp.demo.services.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "")
@CrossOrigin
@RestController
public class TweetController {

    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    TweetService tweetService;

    @GetMapping(value = "/tweets/all")
    public List<Tweet> getAllTweets(){
        return tweetService.getAll();
    }

    @GetMapping(value="/profile/{username}/posts")
    public List<Tweet> getUsersTweet(@PathVariable String username){
        System.out.println("logs");
        return tweetService.getTweetOfUser(username);
    }

    @GetMapping(value ="/profile/{username}")
    public ResponseEntity<Object> getUsersDetails(@PathVariable String username){

        Map<String, Object> res = new HashMap<String, Object>();
        res.put("profileUsername",username);
        res.put("counts",tweetService.getTweetOfUser(username).size());
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }

    //create tweet
    @GetMapping(value="/tweets/post/{id}")
    public Tweet getTweet(@PathVariable Long id ){
        return tweetService.getTweetbyId(id);
    }

    @PostMapping(value="/tweets/{username}/add")
    public ResponseEntity<Object> postUsersTweet(@PathVariable String username, @RequestBody TweetDto tweetDto){
        System.out.println("inside add tweet");
        Tweet tweet = tweetService.addTweetOfUser(username,tweetDto);
        if(tweet==null)
            return new ResponseEntity<>("notCreated",null, HttpStatus.CREATED);//need to impl
        return new ResponseEntity<>(tweet.getTweetId(),null, HttpStatus.CREATED);
    }

    @PostMapping(value="/tweets/post/{id}/update/{username}")//<username>/update/<id>
    public ResponseEntity<Object> updateUsersTweet(@PathVariable String username, @PathVariable Long id, @RequestBody TweetDto tweetDto ){
        System.out.println("inside constroller");
        if(!tweetService.updateTweetOfUser(username,id, tweetDto))
            return ResponseEntity.badRequest().body("Not Updated");//need to impl
        return new ResponseEntity<>("updated",null, HttpStatus.CREATED);
    }

    @DeleteMapping(value="/tweets/{username}/delete/{id}")//<username>/delete/<id>
    public ResponseEntity<Object> deleteUsersTweet(@PathVariable String username, @PathVariable Long id){
//        if(!tweetService.deleteTweetOfUser(username,id))
//            return ResponseEntity.badRequest().body("not deleted");//need to impl
//        return ResponseEntity.accepted().body("deleted");
        try {
            System.out.println("in controller");
            kafkaProducer.sendMessage(String.valueOf(id));
            //kafkaProducer.sendId(id);
            return new ResponseEntity<>("done", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Application has faced an issue",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="/tweets/{username}/like/{id}")//<username>/like/<id>
    public ResponseEntity<Object> likeUsersTweet(@PathVariable String username, @PathVariable Long id){
        System.out.println("insisde constroller");
        if(!tweetService.likeTweetOfUser(username,id))
            return ResponseEntity.badRequest().body("not updated");//need to impl
        return ResponseEntity.ok("liked");
    }

    @PostMapping(value="/tweets/{username}/reply/{id}")//<username>/reply/<id>
    public ResponseEntity<Object> replyUsersTweet(@PathVariable String username, @PathVariable Long id
            , @RequestBody @Valid RlyTweet rlyCont){
        if(!tweetService.replyTweetOfUser(username,id, rlyCont)) {
            System.out.println("check");
            return ResponseEntity.badRequest().body("not updated");//need to impl
        }else {
            System.out.println("in cont");
            return ResponseEntity.ok(HttpStatus.CREATED);
        }
    }


}
