package com.estu.vtys.redisexample.repository;

import com.estu.vtys.redisexample.model.Product;

import java.util.Map;

public interface ProductRepository {

    Product save(Product product);

    Map<String, Product> save(Map<String, Product> productMap);

    Product findById(String id);

    Map<String, Product> findAll();
}
