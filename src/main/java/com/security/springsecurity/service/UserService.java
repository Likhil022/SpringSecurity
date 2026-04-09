package com.security.springsecurity.service;

import com.security.springsecurity.model.Users;
import com.security.springsecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    public UserRepo userRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users registerUser(Users user) throws Exception{
        if(userRepo.findByUsername(user.getUsername()) != null){
            throw new Exception("User Already Exists");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return user;
    }
}
