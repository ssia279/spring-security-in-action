package com.johnsonwang.ssia.controller;

import com.johnsonwang.ssia.model.Product;
import com.johnsonwang.ssia.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/find")
    public List<Product> sellProduct() {
        return this.productService.findProducts();
    }
}
