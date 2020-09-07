package com.chrisboer.greetingservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/greet")
public interface GreetingController {
    @GetMapping
    GreetingDTO greet();
}
