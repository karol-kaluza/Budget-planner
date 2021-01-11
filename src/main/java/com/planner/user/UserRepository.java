package com.planner.user;

import java.util.Collection;

public interface UserRepository {
    void save (User user);
    void remove (String username);
    User findByUsername(String username);
    Collection<User> findAll();
}
