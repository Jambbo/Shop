package com.example.springshop.service.impl;

import com.example.springshop.dao.ProductRepository;
import com.example.springshop.dto.ProductDTO;
import com.example.springshop.mapper.ProductMapper;
import com.example.springshop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductMapper mapper = ProductMapper.MAPPER;
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> getAll() {
        return mapper.fromProductList(productRepository.findAll());
    }
}
