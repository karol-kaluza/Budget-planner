package com.planner.user.repository;

import com.planner.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.UUID;

@RepositoryRestResource(path = "user")
public interface UserRepository extends JpaRepository<User, UUID> {

}
