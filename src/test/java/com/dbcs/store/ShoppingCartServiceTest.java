package com.dbcs.store;

import com.dbcs.store.model.ShoppingCart;
import com.dbcs.store.repository.ShoppingCartRepository;
import com.dbcs.store.service.ShoppingCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartServiceTest {

    @Mock
    ShoppingCartRepository shoppingCartRepository;

    @InjectMocks
    ShoppingCartService shoppingCartService;

    @Test
    public void whenAddingProductShouldReturnProduct() {
        ShoppingCart original = shoppingCartService.createShoppingCart();

        assert original != null : "Nothing returned!";
    }
}
