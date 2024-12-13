package com.example.demo.controller;

import com.example.demo.dto.UserDetails;
import com.example.demo.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    UserServiceImpl  userService;

    @Test
    public void testSaveUserDetails() throws Exception {

        UserDetails userDetails = new UserDetails();
        userDetails.setUserId(1L);
        userDetails.setName("Gopal");
        userDetails.setAdress("ATP");

        when(userService.saveUserDetails(userDetails)).thenReturn(userDetails);
        UserDetails user = userController.saveUserDetails(userDetails);

        assertEquals("Gopal", user.getName());
        assertNotEquals("Mahi", user.getName());

    }

    @Test
    public void testFetchUserdettailsList() {

        List<UserDetails> listOfUsers = new ArrayList<>();
        UserDetails userDetails1 = new UserDetails(1L,"Bittu","SDP");
        UserDetails userDetails2 = new UserDetails(2L,"Pranav","MVP");
        UserDetails userDetails3 = new UserDetails(3L,"Bablu","BNG");

        listOfUsers.add(userDetails1);
        listOfUsers.add(userDetails2);
        listOfUsers.add(userDetails3);

        when(userService.fetchUserDetailsList()).thenReturn(listOfUsers);

        List<UserDetails> userDetailsList = userService.fetchUserDetailsList();
        int size = userDetailsList.size();
        assertEquals(3, size);
    }
}
