package com.planner.user.controller;

import com.planner.user.model.User;
import com.planner.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.planner.user.functions.UserFunctions.dataMapToUser;
import static com.planner.user.functions.UserFunctions.oAuth2UserToMap;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/check")
    public String checkUser(@AuthenticationPrincipal OAuth2User principal) {
        User user = dataMapToUser.apply(oAuth2UserToMap.apply(principal));
        if(!userRepository.existsById(user.getId())) {
            userRepository.save(user);
            return user.getUsername() + " added to our app.";
        }
        return user.getUsername() + " already exists!";
    }
}
