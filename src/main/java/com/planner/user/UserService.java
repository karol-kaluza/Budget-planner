package com.planner.user;

import java.util.List;

public interface UserService {

    void register(String username);

    void removeUser (String username);

    List<User> getAllUsers();

}
