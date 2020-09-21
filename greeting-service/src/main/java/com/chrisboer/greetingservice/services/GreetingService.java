package com.chrisboer.greetingservice.services;

import com.chrisboer.greetingservice.controllers.GreetingDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Autowired
    private UserClient userClient;

    @Value("${user.role}")
    private String role;

    @HystrixCommand(fallbackMethod = "fallbackGreet")
    public GreetingDTO greet() {
//        UserDTO result = new RestTemplate().getForEntity(
//                "http://localhost:9090/api/v1/user",
//                UserDTO.class).getBody();
//        return createGreeting(result.getName());
        return createGreeting(userClient.getRandomUser().getName());
    }

    public GreetingDTO fallbackGreet() {
        return createGreeting("you");
    }

    private GreetingDTO createGreeting(String name) {
        return new GreetingDTO("Hello " + name + "!  " + "Running in role: " + role);
    }
}
