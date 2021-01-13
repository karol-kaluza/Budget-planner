package com.planner.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {

    private UserRepositoryImpl repository;

    @BeforeEach
    void setup() {
        repository = new UserRepositoryImpl();
    }

    @Test
    void findByUsernameWithProperArgument() {
        //given
        String username = "Jack";
        User user = new User("Jack");
        //when
        repository.save(user);
        //then
        assertEquals(repository.findByUsername(username), user);
    }

    @Test
    void notFindByUsernameWithSameUsernameValue() {
        //given
        String username = "Jack";
        User user = new User("Jack");
        //when
        repository.save(user);
        //then
        assertNotEquals(repository.findByUsername(username), new User(username));
    }

    @Test
    void findByUsernameWithWrongArgumentReturnsNull() {
        //given
        String username = "Janek";
        User user = new User("Jack");
        //when
        repository.save(user);
        //then
        assertNull(repository.findByUsername(username));
    }
}