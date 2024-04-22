package com.estu.vtys.redisexample.controller;

import com.estu.vtys.redisexample.model.Product;
import com.estu.vtys.redisexample.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @PostMapping("/add-all")
    public ResponseEntity<Map<String, Product>> addProduct(@RequestBody List<Product> productList) {
        return ResponseEntity.ok(productService.addProduct(productList));
    }

    @GetMapping("/find-all")
    public ResponseEntity<Map<String, Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }
}
