package com.security.springsecurity.service;

import com.security.springsecurity.model.Users;
import com.security.springsecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    public UserRepo userRepo;
    public Users registerUser(Users user) throws Exception{
        if(userRepo.findByUsername(user.getUsername()) != null){
            throw new Exception("User Already Exists");
        }
        userRepo.save(user);
        return user;
    }
}
