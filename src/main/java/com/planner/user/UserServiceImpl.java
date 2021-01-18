package com.planner.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepositoryImpl repository = new UserRepositoryImpl();

    @Override
    public void register(String username) {
        if (username.length() > 1) {
            repository.save(new User(username));
        }
        log.info("New user registered: " + username);
    }

    @Override
    public void removeUser(String username) {
        repository.remove(username);
        log.info("User: " + username + " removed");
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(repository.findAll());
    }
}
