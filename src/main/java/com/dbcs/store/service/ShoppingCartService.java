package com.dbcs.store.service;

import com.dbcs.store.model.Product;
import com.dbcs.store.model.ShoppingCart;
import com.dbcs.store.repository.ProductRepository;
import com.dbcs.store.repository.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {
    private final ProductRepository productRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCart createShoppingCart() {
        ShoppingCart newShoppingCart = new ShoppingCart();
        shoppingCartRepository.save(newShoppingCart);
        return newShoppingCart;
    }

    public void addProduct(Integer productId, Integer shoppingCartId) {
        boolean isProductPresent = productRepository
                .findById(productId)
                .isPresent();
        boolean isShoppingCartPresent = shoppingCartRepository
                .findById(shoppingCartId)
                .isPresent();

        if (isProductPresent && isShoppingCartPresent) {
            Product product = productRepository
                    .findById(productId)
                    .get();

            ShoppingCart shoppingCart = shoppingCartRepository
                    .findById(shoppingCartId)
                    .get();

            shoppingCart.addProduct(product);
            shoppingCartRepository.save(shoppingCart);
        }
    }

    public void removeProduct(Integer productId, Integer shoppingCartId) {
        boolean isProductPresent = productRepository
                .findById(productId)
                .isPresent();
        boolean isShoppingCartPresent = shoppingCartRepository
                .findById(shoppingCartId)
                .isPresent();

        if (isProductPresent && isShoppingCartPresent) {
            Product product = productRepository
                    .findById(productId)
                    .get();

            ShoppingCart shoppingCart = shoppingCartRepository
                    .findById(shoppingCartId)
                    .get();

            shoppingCart.removeProduct(product);
            shoppingCartRepository.save(shoppingCart);
        }
    }

    public Integer totalPrice(Integer shoppingCartId) {
        if (shoppingCartRepository.findById(shoppingCartId).isEmpty()) {
            return -1;
        }

        return shoppingCartRepository
                .findById(shoppingCartId)
                .get()
                .totalPrice();
    }
}


