package com.chrisboer.userservice.controllers;

import com.chrisboer.userservice.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public UserDTO getRandomUser() {
        return userService.getRandomUser();
    }

}
