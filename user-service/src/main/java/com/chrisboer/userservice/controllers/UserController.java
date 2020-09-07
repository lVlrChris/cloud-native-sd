package com.chrisboer.userservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/vi/user")
public interface UserController {
    @GetMapping
    UserDTO getRandomUser();
}
