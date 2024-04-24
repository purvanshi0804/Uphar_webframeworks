package com.example.upahar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.upahar.model.User;
import com.example.upahar.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User getUser(int id){
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUserDetails()
    {
        return userRepository.findAll();
    }
    public void deleteUser(int id)
    {
        userRepository.deleteById(id);
    }

    public List<User> getUserDetailUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

}
