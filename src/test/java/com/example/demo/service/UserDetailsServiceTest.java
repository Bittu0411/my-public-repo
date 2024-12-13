package com.example.demo.service;


import com.example.demo.dto.UserDetails;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserDetailsServiceTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Test
    void testFetchUserDetailsList() {

        List<UserDetails> userDetailsList = new ArrayList<>();

        UserDetails userDetails1 = new UserDetails(1L,"Gopal","Bangalore");
        UserDetails userDetails2 = new UserDetails(2L,"Ram","AP");
        UserDetails userDetails3 = new UserDetails(3L,"Krishna","KA");
        UserDetails userDetails4 = new UserDetails(4L,"Pranav","Anantapur");

        userDetailsList.add(userDetails1);
        userDetailsList.add(userDetails2);
        userDetailsList.add(userDetails3);
        userDetailsList.add(userDetails4);

        when(userRepository.findAll()).thenReturn(userDetailsList);

        List<UserDetails> listofUsers = userService.fetchUserDetailsList();
//        List<UserDetails> listofUsers2 = userService.fetchUserDetailsList();
        assertEquals(4, listofUsers.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testSaveUserDetails() {

        UserDetails userDetails = new UserDetails(1L, "Gopal", "HYD");
        userService.saveUserDetails(userDetails);
        verify(userRepository, times(1)).save(userDetails);


    }
}
