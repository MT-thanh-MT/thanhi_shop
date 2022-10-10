package com.thanhi.service;

import com.thanhi.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();
    List<Product> findByCategoryId(Integer cid);
    Product findById(Long id);
}
