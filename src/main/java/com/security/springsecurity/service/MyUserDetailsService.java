package com.security.springsecurity.service;

import com.security.springsecurity.model.UserPrinciple;
import com.security.springsecurity.model.Users;
import com.security.springsecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    public UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);
        if(user == null){
            System.out.println("No User Found");
            throw new UsernameNotFoundException("user not found");
        }
        return new UserPrinciple(user);

    }
}
