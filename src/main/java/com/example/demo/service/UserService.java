package com.example.demo.service;

import com.example.demo.dto.UserDetails;
import org.apache.catalina.UserDatabase;
import org.springframework.http.codec.multipart.DefaultPartHttpMessageReader;

import java.util.List;

public interface UserService {


    UserDetails saveUserDetails(UserDetails userDetails);

    List<UserDetails>  fetchUserDetailsList();

    void deleteUserDetailsById(Long userId);

    UserDetails updateUserDetails(UserDetails userdetails, Long userId);
}
