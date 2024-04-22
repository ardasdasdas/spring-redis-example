package com.estu.vtys.redisexample.repository;

import com.estu.vtys.redisexample.model.Product;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private static final String HASH_KEY = "Product";

    private final HashOperations<String, String, Product> hashOperations;

    public ProductRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Product save(Product product) {
        hashOperations.put(HASH_KEY, product.getId(), product);
        return product;
    }

    @Override
    public Map<String, Product> save(Map<String, Product> productMap) {
        hashOperations.putAll(HASH_KEY, productMap);
        return productMap;
    }

    @Override
    public Product findById(final String id) {
        return hashOperations.get(HASH_KEY, id);
    }

    @Override
    public Map<String, Product> findAll() {
        return hashOperations.entries(HASH_KEY);
    }

}
