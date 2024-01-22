package com.example.springshop.service;

import com.example.springshop.domain.User;
import com.example.springshop.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;


public interface UserService extends UserDetailsService {//security
    boolean save(UserDTO userDTO);
    void save(User user);
    List<UserDTO> getAll();
    User findByName(String name);
    void updateProfile(UserDTO dto);
}
