package com.planner.user.controller;

import com.planner.user.model.User;
import com.planner.user.repository.UserRepository;
import com.planner.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/user-checkout")
    public String checkUser(@AuthenticationPrincipal OAuth2User principal) {
        return principal.getAttribute("name") + " will be added to our app.";
    }

    // TODO: 10/02/2021
    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        userRepository.save(new User(principal.getAttribute("name"), principal.getAttribute("node_id")));
        return principal.getAttributes();
    }
}
