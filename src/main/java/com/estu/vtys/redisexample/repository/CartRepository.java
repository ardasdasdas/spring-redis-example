package com.estu.vtys.redisexample.repository;

import java.util.Map;

public interface CartRepository {

    void addItem(String userId, String productId);

    void removeItem(String userId, String productId);

    Map<String, String> getCart(String userId);
}
