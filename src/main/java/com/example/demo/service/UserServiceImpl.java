package com.example.demo.service;

import com.example.demo.dto.UserDetails;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl  implements  UserService{


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails saveUserDetails(UserDetails userDetails) {
        return userRepository.save(userDetails);
    }

    @Override
    public List<UserDetails> fetchUserDetailsList() {
        return (List<UserDetails>) userRepository.findAll();
    }

    @Override
    public void deleteUserDetailsById(Long userId) {
         userRepository.deleteById(userId);
    }

    @Override
    public UserDetails updateUserDetails(UserDetails userdetails, Long userId) {
        UserDetails userDetailsRepo = userRepository.findById(userId).get();

        if(Objects.nonNull(userdetails.getName()) && !"".equalsIgnoreCase(userdetails.getName())) {
            userDetailsRepo.setName(userdetails.getName());
        }

        if(Objects.nonNull(userdetails.getAdress()) && !"".equalsIgnoreCase(userdetails.getAdress())) {
            userDetailsRepo.setAdress(userdetails.getAdress());
        }
        return userRepository.save(userDetailsRepo);
    }
}
