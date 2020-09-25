package com.practice.crudproduct.service;

import com.practice.crudproduct.entity.ProductDetail;
import com.practice.crudproduct.exception.ProductDetailsNotFoundException;
import com.practice.crudproduct.repository.ProductDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailsService implements CrudService<ProductDetail, Long> {
    @Autowired
    private ProductDetailsRepository productDetailsRepository;

    @Override
    public ProductDetail save(ProductDetail productDetail) {
        return productDetailsRepository.save(productDetail);
    }

    @Override
    public ProductDetail findById(Long aLong) {
        return productDetailsRepository.findById(aLong).orElseThrow(ProductDetailsNotFoundException::new);
    }

    @Override
    public void deleteById(Long aLong) {
        productDetailsRepository.deleteById(aLong);
    }

    @Override
    public void delete(ProductDetail productDetail) {
        productDetailsRepository.delete(productDetail);
    }
}
