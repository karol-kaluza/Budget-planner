package com.planner.user;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getUsername(), user);

    }

    @Override
    public User findByUsername(String username) {
        return users.get(username);
    }

    @Override
    public Collection<User> findAll() {
        return users.values();
    }
}
