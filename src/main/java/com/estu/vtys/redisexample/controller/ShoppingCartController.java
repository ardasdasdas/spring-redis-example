package com.estu.vtys.redisexample.controller;

import com.estu.vtys.redisexample.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @PostMapping("/add/{userId}/{productId}")
    public ResponseEntity<String> addToCart(@PathVariable String userId, @PathVariable String productId) {
        return ResponseEntity.ok(shoppingCartService.addProductToCart(userId, productId));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Map<String, String>> getCart(@PathVariable String userId) {
        return ResponseEntity.ok(shoppingCartService.getCart(userId));
    }
}