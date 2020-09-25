package com.practice.crudproduct.service;


import com.practice.crudproduct.entity.Product;
import com.practice.crudproduct.exception.ProductNotFoundException;
import com.practice.crudproduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements CrudService<Product, Long> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long aLong) {
        return productRepository.findById(aLong).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public void deleteById(Long aLong) {
        productRepository.deleteById(aLong);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }
}
