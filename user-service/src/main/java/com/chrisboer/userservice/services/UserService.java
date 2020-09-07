package com.chrisboer.userservice.services;

import com.chrisboer.userservice.controllers.UserDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class UserService {
    @HystrixCommand(fallbackMethod = "fallbackUser")
    public UserDTO getRandomUser() {
        Random random = new Random();
        int randomId = random.nextInt(9) + 1;

        return new RestTemplate().getForEntity(
                "https://jsonplaceholder.typicode.com/users/" + randomId,
                UserDTO.class).getBody();
    }

    public UserDTO fallbackUser() {
        return new UserDTO("Default Name");
    }
}
