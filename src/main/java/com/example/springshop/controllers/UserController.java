package com.example.springshop.controllers;

import com.example.springshop.domain.User;
import com.example.springshop.dto.UserDTO;
import com.example.springshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Objects;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String userList(Model model){
//        if(1==1){
//            throw new RuntimeException("test of error handling"); //test of error handling
//        }
        model.addAttribute("users",userService.getAll());
        return "userList";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user",new UserDTO());
        return "user";
    }
    @PostMapping("/new")
    public String saveUser(UserDTO userDTO,Model model){
        if(userService.save(userDTO)){
            return "redirect:/users";
        }else{
            model.addAttribute("user",userDTO);
            return "user";
        }
    }
    @GetMapping("/profile")
    public String profileUser(Model model, Principal principal){
        if(principal==null){
            throw new RuntimeException("You are not authrized");
        }
        User user = userService.findByName(principal.getName());

        UserDTO dto = UserDTO.builder()
                .username(user.getName())
                .email(user.getEmail())
                .build();
        model.addAttribute("user",dto);
        return "profile";
    }
    @PostMapping("/profile")
    public String updateProfileUser(UserDTO dto, Model model, Principal principal){
        if(principal ==null || !Objects.equals(principal.getName(),dto.getUsername())){
            throw new RuntimeException("You are not authorized");
        }
        if(dto.getPassword()!=null
                            && !dto.getPassword().isEmpty()
                            && !Objects.equals(dto.getPassword(),dto.getMatchingPassword())){
            model.addAttribute("user",dto);
            return "profile";
        }
        userService.updateProfile(dto);
        return "redirect:/users/profile";
    }

}
