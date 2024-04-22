package com.estu.vtys.redisexample.service;

import com.estu.vtys.redisexample.model.Product;
import com.estu.vtys.redisexample.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Map<String, Product> addProduct(List<Product> productList) {
        Map<String, Product> productMap = productList.stream()
                .collect(Collectors.toMap(Product::getId, Function.identity()));
        return productRepository.save(productMap);
    }

    @Override
    public Map<String, Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public void decreaseStock(Product product) {
        product.setStock(product.getStock() - 1);
        productRepository.save(product);
    }
}
