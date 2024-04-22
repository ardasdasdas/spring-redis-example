package com.estu.vtys.redisexample.service;

import com.estu.vtys.redisexample.exception.OutOfStockException;
import com.estu.vtys.redisexample.exception.ProductNotFoundException;
import com.estu.vtys.redisexample.exception.error.ProductErrorMessage;
import com.estu.vtys.redisexample.model.Product;
import com.estu.vtys.redisexample.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private static final String CART_KEY_PREFIX = "user:cart:";

    private final ProductService productService;

    private final CartRepository cartRepository;

    @Override
    @Transactional
    public String addProductToCart(String userId, String productId) {
        Product product = productService.findById(productId);

        productIsExistControl(product);
        stockControl(product);

        cartRepository.addItem(getCartKey(userId), productId);
        productService.decreaseStock(product);
        return product.getName();
    }

    @Override
    public Map<String, String> getCart(final String userId) {
        return cartRepository.getCart(userId);
    }

    private static String getCartKey(final String userId) {
        return CART_KEY_PREFIX + userId;
    }

    private void productIsExistControl(Product product) {
        if (isNull(product)) {
            throw new ProductNotFoundException(ProductErrorMessage.PRODUCT_NOT_FOUND_MESSAGE.toString());
        }
    }

    private void stockControl(Product product) {
        if (product.getStock() < 0) {
            throw new OutOfStockException(
                    ProductErrorMessage.OUT_OF_STOCK_MESSAGE.getExceptionMessage(product.getId()));
        }
    }
}
