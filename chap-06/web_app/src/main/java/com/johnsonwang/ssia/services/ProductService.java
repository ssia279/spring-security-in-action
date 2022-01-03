package com.johnsonwang.ssia.services;

import com.johnsonwang.ssia.entities.Product;
import com.johnsonwang.ssia.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }
}
