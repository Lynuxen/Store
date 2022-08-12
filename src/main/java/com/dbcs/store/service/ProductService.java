package com.dbcs.store.service;

import com.dbcs.store.model.Product;
import com.dbcs.store.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product addProduct(Product product) {
        System.out.println(product.getName());
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getAvailableProducts() {
        return productRepository
                .findAll()
                .stream()
                .filter(Predicate.not(Product::getDeleted)).toList();
    }

    public void updateProduct(Integer id, Integer stock) {
        if (productRepository.findById(id).isEmpty()) {
            return;
        }
        Product aux = productRepository.findById(id).get();
        aux.setStock(stock);
        productRepository.save(aux);

    }
    public void deleteProduct(Integer id) {
        if (productRepository.findById(id).isEmpty()) {
            return;
        }
        Product aux = productRepository.findById(id).get();
        aux.setDeleted(true);
        productRepository.save(aux);
    }

    public void decrementByOne(Integer id) {
        if (productRepository.findById(id).isEmpty()) {
            return;
        }
        Product aux = productRepository.findById(id).get();
        if (aux.getStock() <= 0) {
            return;
        }
        aux.setStock(aux.getStock() - 1);
        productRepository.save(aux);
    }

    public void incrementByOne(Integer id) {
        if (productRepository.findById(id).isEmpty()) {
            System.out.println("PRODUCT NOT FOUND!");
            return;
        }
        Product aux = productRepository.findById(id).get();
        aux.setStock(aux.getStock() + 1);
        productRepository.save(aux);
    }

}
