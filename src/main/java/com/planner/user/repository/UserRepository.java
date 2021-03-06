package com.planner.user.repository;

import com.planner.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "user")
public interface UserRepository extends JpaRepository<User, Integer> {

    //todo Add method to compare users
    boolean existsByUsername(String username);

    User findByUsername(String username);
}
