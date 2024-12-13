package com.example.demo.controller;


import com.example.demo.dto.UserDetails;
import com.example.demo.service.UserServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/userdetails")
    public UserDetails saveUserDetails(@RequestBody UserDetails userDetails) {

        return userService.saveUserDetails(userDetails);
    }
    @GetMapping("/userdetails")
    public List<UserDetails> fetchUserDetails() {

        return userService.fetchUserDetailsList();
    }

    @DeleteMapping("/userdetails/{id}")
    public String deleteUserDetailsById(@PathVariable("id") Long userId) {

        userService.deleteUserDetailsById(userId);

        return "User deleted successfully";
    }

    @PutMapping("/userdetails/{id}")
    public UserDetails updateUserDetailsById(@RequestBody UserDetails userDetails,@PathVariable("id") Long userId) {

        return userService.updateUserDetails(userDetails, userId);
    }
}
