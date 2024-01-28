package com.example.springshop.controllers;

import com.example.springshop.domain.Bucket;
import com.example.springshop.domain.User;
import com.example.springshop.dto.BucketDTO;
import com.example.springshop.dto.ProductDTO;
import com.example.springshop.service.BucketService;
import com.example.springshop.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.Map;

@Controller
public class BucketController {
    private final UserService userService;

    private final BucketService bucketService;

    public BucketController(UserService userService, BucketService bucketService) {
        this.userService = userService;
        this.bucketService = bucketService;
    }

    @GetMapping("/bucket")
    public String aboutBucket(Model model, Principal principal) {
        if (principal == null) {
            model.addAttribute("bucket", new BucketDTO());
        } else {
            BucketDTO bucketDTO = bucketService.getBucketByUser(principal.getName());
            model.addAttribute("bucket", bucketDTO);
        }
        return "bucket";
    }


    }

