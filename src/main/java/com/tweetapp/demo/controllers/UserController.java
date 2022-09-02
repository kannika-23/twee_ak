package com.tweetapp.demo.controllers;

import com.tweetapp.demo.dtomodels.UserDto;
import com.tweetapp.demo.dtomodels.UserLoginDto;
import com.tweetapp.demo.dtomodels.UserPasswordDto;
import com.tweetapp.demo.exceptions.ParametersMismatchException;
//import com.tweetapp.demo.kafka.KafkaSender;
//import com.tweetapp.demo.kafka.KafkaProducer;
//import com.tweetapp.demo.kafka.KafkaProducer;
import com.tweetapp.demo.models.User;
import com.tweetapp.demo.security.JwtTokenUtil;
import com.tweetapp.demo.security.JwtUserDetailsService;
import com.tweetapp.demo.services.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    //@Autowired
    //private AuthenticationManager authenticationManager;
//    @Autowired
//    private KafkaProducer kafkaProducer;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    //@Autowired
    //KafkaSender kafkaSender;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid @NotNull UserLoginDto userLoginDto, BindingResult result) throws Exception {
        if(result.hasErrors()) {
            //log.debug("inside pensionerDetail - add Pensioner details - hasError");
            throw new ParametersMismatchException("Entered invalid parameters");
        }

      /*  userService.loginCheck(userLoginDto);
       // final String token = jwtUtil.generateToken(userLoginDto);
       // return new ResponseEntity<>("tweets",null,HttpStatus.ACCEPTED);
        //System.out.println(token);
        //return new ResponseEntity<>(token,null,HttpStatus.ACCEPTED);
        //Map<String, Object> res = new HashMap<String, Object>();
        //res.put("Authentication","Bearer "+token);

        //return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
        return new ResponseEntity<>("tweet",HttpStatus.ACCEPTED);*/
        //authenticate(userLoginDto.getEmail(), userLoginDto.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(userLoginDto.getEmail());
        String username = userService.loginCheck(userLoginDto);
        System.out.println(username);
        final String token = jwtTokenUtil.generateToken(userDetails);
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("token","Bearer "+token);
        res.put("username",username);

        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }

    /*private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }*/

        @PostMapping("/register")
        public ResponseEntity<Object> addUser(@RequestBody @Valid @NotNull UserDto user,  BindingResult result) throws ParametersMismatchException {
            if(result.hasErrors()) {
                log.info("inside pensionerDetail - add Pensioner details - hasError");
                System.out.println(result.getFieldError().toString());
                throw new ParametersMismatchException("Entered invalid parameters");
            }
            userService.addUser(user);
            return ResponseEntity.ok(HttpStatus.CREATED);
           // return ResponseEntity.ok().body("Message")
        }
    @PostMapping("/forgetPassword")
    public ResponseEntity<Object> forgetPassword(@RequestBody @Valid @NotNull UserPasswordDto userPasswordDto, BindingResult result) throws ParametersMismatchException {
        if(result.hasErrors()) {
            //log.debug("inside pensionerDetail - add Pensioner details - hasError");
            System.out.println(result.getFieldError().toString());
            throw new ParametersMismatchException("Entered invalid parameters");
        }
        userService.updatePassword(userPasswordDto);
        //return new ResponseEntity<>("done",null,HttpStatus.ACCEPTED);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @GetMapping("/check")
    public ResponseEntity<Object> check(){
        // userService.updatePassword(userPasswordDto);@RequestParam("message") String message
        //kafkaSender.send("msg");
        //kafkaProducer.sendMessage("message");
        return ResponseEntity.ok("tweets");
    }

    @GetMapping(value = "/users/all") //tweets/users/all
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //user/search/username
    @GetMapping(value = "user/search/{username}") //tweets/users/all
    public User getAllUsers(@PathVariable String username){
        return userService.getUsersDetails(username);
    }
}
