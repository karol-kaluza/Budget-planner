package com.planner.user.controller;

import com.planner.user.User;
import com.planner.user.UserService;
import com.planner.user.model.PlainResponse;
import com.planner.user.model.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/register")
    public ResponseEntity<PlainResponse> registerUser(@RequestBody RegisterRequest registerRequest) {
        userService.register(registerRequest.getUsername());
        return ResponseEntity.ok(new PlainResponse("User saved!"));
    }

    @PutMapping("/removed")
    public ResponseEntity<PlainResponse> removeUser(@RequestBody RegisterRequest registerRequest) {
        userService.removeUser(registerRequest.getUsername());
        return ResponseEntity.ok(new PlainResponse("User removed!"));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}