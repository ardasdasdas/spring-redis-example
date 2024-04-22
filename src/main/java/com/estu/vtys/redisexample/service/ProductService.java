package com.estu.vtys.redisexample.service;

import com.estu.vtys.redisexample.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    Product addProduct(Product product);

    Map<String, Product> addProduct(List<Product> product);

    Map<String, Product> findAll();

    Product findById(String id);

    void decreaseStock(Product product);

}
