package com.planner.user;

import java.util.Collection;

public interface UserRepository {
    void save (User user);
    User findByUsername(String username);
    Collection<User> findAll();
}
