package com.estu.vtys.redisexample.repository;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CartRepositoryImpl implements CartRepository {

    private final HashOperations<String, String, String> hashOperations;

    public CartRepositoryImpl(RedisTemplate<String, String> redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void addItem(String cartKey, String productId) {
        hashOperations.increment(cartKey, productId, 1);
    }

    @Override
    public void removeItem(String cartKey, String productId) {
        hashOperations.delete(cartKey, productId);
    }

    @Override
    public Map<String, String> getCart(String cartKey) {
        return hashOperations.entries(cartKey);
    }

}
