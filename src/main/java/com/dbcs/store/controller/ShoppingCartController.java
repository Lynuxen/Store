package com.dbcs.store.controller;

import com.dbcs.store.model.ShoppingCart;
import com.dbcs.store.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("cart")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    @PutMapping("add/{productId}/{shoppingCartId}")
    public void addProduct(@PathVariable Integer productId, @PathVariable Integer shoppingCartId) {
        shoppingCartService.addProduct(productId, shoppingCartId);
    }

    @DeleteMapping("delete/{productId}/{shoppingCartId}")
    public void removeProduct(@PathVariable Integer productId, @PathVariable Integer shoppingCartId) {
        shoppingCartService.removeProduct(productId, shoppingCartId);
    }

    @GetMapping("price/{shoppingCartId}")
    public Integer totalPrice(@PathVariable Integer shoppingCartId) {
        return shoppingCartService.totalPrice(shoppingCartId);
    }

    @PostMapping
    public ShoppingCart createShoppingCart() {
        return shoppingCartService.createShoppingCart();
    }
}
