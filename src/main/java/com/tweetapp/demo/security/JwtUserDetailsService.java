package com.tweetapp.demo.security;

import java.util.ArrayList;

import com.tweetapp.demo.dao.UserRepo;
import com.tweetapp.demo.dtomodels.UserLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            UserLoginDto user = new UserLoginDto(userRepository.findItemByUserid(username).getEmail(), userRepository.findItemByUserid(username).getPassword());
            UserDetails  userDetails = new User(user.getEmail(), user.getPassword(), new ArrayList<>());
            return userDetails;
        }catch (Exception ex) {
            throw new UsernameNotFoundException("User Not Found with ID: " + username);
        }

    }

}