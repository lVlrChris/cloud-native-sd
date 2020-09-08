package com.chrisboer.greetingservice.services;

import com.chrisboer.greetingservice.controllers.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "user-service")
public interface UserClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/user")
    UserDTO getRandomUser();
}
