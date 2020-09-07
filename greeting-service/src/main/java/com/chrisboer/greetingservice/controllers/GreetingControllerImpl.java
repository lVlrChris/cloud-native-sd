package com.chrisboer.greetingservice.controllers;

import com.chrisboer.greetingservice.services.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/greet")
public class GreetingControllerImpl implements GreetingController {

    final GreetingService greetingService;

    public GreetingControllerImpl(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public GreetingDTO greet() {
        return greetingService.greet();
    }
}
