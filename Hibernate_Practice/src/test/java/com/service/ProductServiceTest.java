package com.service;

import com.entity.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

public class ProductServiceTest {
    @Test
    public void itShouldInsertProductReturnProductThatInserted() {
        Product product = new Product();
        product.setName("Bun Cha");
        product.setPrice(20D);

        Product productResult = new ProductService().insert(product);
        assertEquals(productResult, product);
    }

    @Test
    public void itShouldSelectAllProductReturnAllProduct() {
        Set<Product> productSet= new ProductService().selectAll();
        assertTrue(productSet.size() > 0);
    }

    @Test
    public void itShouldSelectProductByIdReturnProduct() {
        Long id = 2L;
        Product product = new ProductService().selectById(id);
        assertThat(product).isNotNull();
    }

    @Test
    public void itShouldSelectProductByIdThrowProductException() {
        Long id = 1L;
        String actualMessenger = assertThrows(CrudService.TException.class,
                () -> new ProductService().selectById(id)).getMessage();
        String messenger = "select by id field!";
        assertEquals(messenger, actualMessenger);
    }

    @Test
    public void itShouldDeleteProductByIdThatReturnTrue() {
        Long id = 2L;
        Product product = new Product();
        product.setId(id);
        product.setName("Doraemon");
        boolean result = new ProductService().delete(product);
        assertTrue(result);
    }

    @Test
    public void itShouldDeleteProductByIdThrowProductException() {
        Long id = 2L;
        Product product = new Product();
        product.setId(id);
        product.setName("Doraemon");
        String actualMessenger =
                assertThrows(CrudService.TException.class,
                        () -> new ProductService().delete(product)).getMessage();
        String messenger = "delete field!";
        assertEquals(actualMessenger, messenger);
    }

    @Test
    public void itShouldUpdateProductThatReturnProductUpdated() {
        ProductService productService = new ProductService();
        Product product = productService.selectById(3L);
        product.setName("Doraemon");
        Product ProductResult = productService.update(product);
        assertEquals(product, ProductResult);
    }

    @Test void itShouldUpdateProductThrowProductException() {
        Product product = new Product();
        product.setId(1L);
        product.setName("updated");
        String actualMessenger = assertThrows(CrudService.TException.class,
                () -> new ProductService().update(product)).getMessage();
        String messenger = "update field!";
        assertEquals(messenger, actualMessenger);
    }
}
