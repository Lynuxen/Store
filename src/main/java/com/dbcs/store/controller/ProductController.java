package com.dbcs.store.controller;

import com.dbcs.store.model.Product;
import com.dbcs.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("add")
    public Product addProduct(@RequestBody Product product) {
        System.out.println(product.getName());
        return productService.addProduct(product);
    }

    @GetMapping("all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("available")
    public List<Product> getAvailableProducts() {
        return productService.getAvailableProducts();
    }

    @PutMapping("update/{id}/{stock}")
    public void updateProduct(@PathVariable Integer id, @PathVariable Integer stock) {
        productService.updateProduct(id, stock);
    }

    @PutMapping("delete/{id}")
    public void deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);
    }

    @PutMapping("increment/{id}")
    public void incrementProduct(@PathVariable Integer id) {
        productService.incrementByOne(id);
    }

    @PutMapping("decrement/{id}")
    public void decrementProduct(@PathVariable Integer id) {
        productService.decrementByOne(id);
    }
}
