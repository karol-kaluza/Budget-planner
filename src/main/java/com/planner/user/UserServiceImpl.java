package com.planner.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepositoryImpl repository = new UserRepositoryImpl();

    @Override
    public void register(String username) {
        repository.save(new User(username));
    }

    @Override
    public void removeUser(String username) {
        repository.remove(username);

    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(repository.findAll());
    }
}