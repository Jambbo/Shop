package com.example.springshop.service;

import com.example.springshop.domain.Bucket;
import com.example.springshop.domain.Product;
import com.example.springshop.domain.User;
import com.example.springshop.dto.BucketDTO;
import com.example.springshop.dto.ProductDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface BucketService {

    Bucket createBucket(User user, List<Long> productIds);

    void addProducts(Bucket bucket, List<Long> productIds);

    BucketDTO getBucketByUser(String name);

}
