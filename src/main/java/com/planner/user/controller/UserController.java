package com.planner.user.controller;

import com.planner.user.model.User;
import com.planner.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.planner.user.functions.UserFunctions.dataMapToUser;
import static com.planner.user.functions.UserFunctions.oAuth2UserToMap;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/check")
    public String checkUser(@AuthenticationPrincipal OAuth2User principal) {
        User user = dataMapToUser.apply(oAuth2UserToMap.apply(principal));
        if(!userRepository.existsByUsername(user.getUsername())) {
            userRepository.save(user);
            log.info(user.getUsername() + " added to our app.");
        } else {
            log.info(user.getUsername() + " already exists!");
        }
        //todo add user deafult value
        return "redirect:/PLN/main";
    }
}
