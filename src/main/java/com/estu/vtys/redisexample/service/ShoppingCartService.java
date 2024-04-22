package com.estu.vtys.redisexample.service;

import java.util.Map;

public interface ShoppingCartService {

    String addProductToCart(final String userId, final String productId);

    Map<String, String> getCart(final String userId);
}
