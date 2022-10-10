package com.thanhi.service.impl;

import com.thanhi.model.Product;
import com.thanhi.repository.ProductRepository;
import com.thanhi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByCategoryId(Integer cid) {
        return productRepository.findByCategoryId(cid);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }
}
