package com.planner.user;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private UserServiceImpl userService;

    @BeforeEach
    void setup() {
        userService = new UserServiceImpl();
    }

    @Test
    void registerProperlyWithProperArgument() {
        //given
        String username = "Jack12";
        //when
        userService.register(username);
        //then
        assertFalse(userService.getAllUsers().isEmpty());
    }

    @Test
    void registerWithEmptyUsername() {
        //given
        String username = "";
        //when
        userService.register(username);
        //then
        assertTrue(userService.getAllUsers().isEmpty());
    }

    @Test
    void registerWithTooShortUsername() {
        //given
        String username = "co";
        //when
        userService.register(username);
        //then
        assertTrue(userService.getAllUsers().isEmpty());
    }

    @Test
    void removeExistingUserProperly() {
        //given
        String username = "user";
        userService.register(username);
        //when
        userService.removeUser(username);
        //then
        assertTrue(userService.getAllUsers().isEmpty());
    }
}