package com.security.springsecurity.contorller;

import com.security.springsecurity.model.Users;
import com.security.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    public UserService service;
    @PostMapping("/register")
    public Users registerUser(@RequestBody Users user) throws Exception {
        return service.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        return service.verify(user);
    }

}
