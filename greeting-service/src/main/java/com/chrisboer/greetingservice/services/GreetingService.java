package com.chrisboer.greetingservice.services;

import com.chrisboer.greetingservice.controllers.GreetingDTO;
import com.chrisboer.greetingservice.controllers.UserDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GreetingService {
    @HystrixCommand(fallbackMethod = "fallbackGreet")
    public GreetingDTO greet() {
        UserDTO result = new RestTemplate().getForEntity(
                "http://localhost:9090/api/v1/user",
                UserDTO.class).getBody();
        return createGreeting(result.getName());
    }

    public GreetingDTO fallbackGreet() {
        return createGreeting("you");
    }

    private GreetingDTO createGreeting(String name) {
        return new GreetingDTO("Hello " + name + "!");
    }
}
