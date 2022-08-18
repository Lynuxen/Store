package com.dbcs.store;

import com.dbcs.store.model.Product;
import com.dbcs.store.repository.ProductRepository;
import com.dbcs.store.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    public void whenAddingProductShouldNotReturnProduct() {
        Product aux = new Product();
        aux.setName("TEST");
        Product original = productService.addProduct(aux);

        assert original == null : "Nothing returned!";
    }
}
