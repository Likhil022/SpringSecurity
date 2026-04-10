package com.security.springsecurity.service;

import com.security.springsecurity.model.Users;
import com.security.springsecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    public UserRepo userRepo;

    @Autowired
    public JWTService jwtService;

    @Autowired
    public AuthenticationManager authManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users registerUser(Users user) throws Exception{
        if(userRepo.findByUsername(user.getUsername()) != null){
            throw new Exception("User Already Exists");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return user;
    }

    public String verify(Users user){
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        return jwtService.generateToken(user.getUsername());
    }
}
