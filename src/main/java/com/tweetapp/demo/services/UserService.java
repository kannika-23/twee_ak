package com.tweetapp.demo.services;

import com.tweetapp.demo.dtomodels.UserDto;
import com.tweetapp.demo.dtomodels.UserLoginDto;
import com.tweetapp.demo.dtomodels.UserPasswordDto;
import com.tweetapp.demo.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User addUser(UserDto user);

    public  String loginCheck(UserLoginDto userLoginDto);

    public void updatePassword(UserPasswordDto userPasswordDto);

    User getUsersDetails(String username);

    List<User> getAllUsers();
}
