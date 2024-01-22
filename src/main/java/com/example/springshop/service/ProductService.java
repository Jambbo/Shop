package com.example.springshop.service;

import com.example.springshop.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();
    void addToUserBucket(Long id, String username);
}
