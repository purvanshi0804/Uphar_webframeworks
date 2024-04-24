package com.example.upahar.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.upahar.model.User;
import com.example.upahar.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/post")
    public String postMethodName(@RequestBody User user) {
        
        userService.saveUser(user);
        return "Saved the user details";
    }

    @GetMapping("/user/{id}")
    public User getMethodName(@PathVariable("id") int a) {
        return userService.getUser(a);
    }

    @GetMapping("/user")
    public List<User> getallani() {
        return userService.getUserDetails();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteQuery(@PathVariable("id") int id) {
        if (userService.getUser(id) != null) {
            userService.deleteUser(id);
        }
        return "Post Deleted Successfully.";
    }


    //Getting the output using the @Query annotation in the repo class
    @GetMapping("/sql/{a}")
    public List<User> getMethodName(@PathVariable("a") String a) {
        return userService.getUserDetailUsername(a);
    }
}
