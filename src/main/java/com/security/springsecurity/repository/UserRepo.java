package com.security.springsecurity.repository;

import com.security.springsecurity.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users,Integer> {
    public Users findByUsername(String username);
}
