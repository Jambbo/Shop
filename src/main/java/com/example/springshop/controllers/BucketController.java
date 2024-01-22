package com.example.springshop.controllers;

import com.example.springshop.dto.BucketDTO;
import com.example.springshop.service.BucketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class BucketController {

    private final BucketService bucketService;

    public BucketController(BucketService bucketService) {
        this.bucketService = bucketService;
    }
    @GetMapping("/bucket")
    public String aboutBucket(Model model, Principal principal){
        if(principal==null){
            model.addAttribute("bucket",new BucketDTO());
        }else{
            BucketDTO bucketDTO = bucketService.getBucketByUser(principal.getName());
            model.addAttribute("bucket",bucketDTO);
        }
        return "bucket";
    }
}

