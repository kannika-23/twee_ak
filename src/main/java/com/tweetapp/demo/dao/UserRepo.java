package com.tweetapp.demo.dao;

import com.tweetapp.demo.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepo  extends MongoRepository<User, String> {

    @Query("{email:'?0'}")
    User findItemByUserid(String email);

  //  @Query("{email:'?0'},{password:'?0'")
   // User findItemByUseridAndPassword(String email,String password);

    //@Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    //@Query(fields="{'email' : 1, 'firstName' : 1}")
    //List<User> findAll();

    public long count();

    @Query("{username:'?0'}")
    User findItemByUsername(String username);
}
