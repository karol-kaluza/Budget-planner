package com.planner.user;

import com.planner.user.User;
import com.planner.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {


    @Override
    public void register(String username, String password) {

    }

    @Override
    public void removeUser(String username) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
