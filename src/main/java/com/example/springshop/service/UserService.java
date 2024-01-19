package com.example.springshop.service;

import com.example.springshop.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


public interface UserService extends UserDetailsService {//security
    boolean save(UserDTO userDTO);
}