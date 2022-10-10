package com.thanhi.rest.controller;

import com.thanhi.model.Product;
import com.thanhi.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
    @Autowired
    ProductServiceImpl productService;

    @GetMapping("{id}")
    public Product getOne(@PathVariable("id") Long id) {
        return productService.findById(id);
    }
}
