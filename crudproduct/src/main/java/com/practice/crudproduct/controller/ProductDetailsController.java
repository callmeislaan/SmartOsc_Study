package com.practice.crudproduct.controller;

import com.practice.crudproduct.entity.ProductDetail;
import com.practice.crudproduct.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productDetails")
public class ProductDetailsController {

    @Autowired
    ProductDetailsService productDetailsService;

    @PostMapping("/save")
    public ProductDetail save(@RequestBody ProductDetail productDetail) {
        return productDetailsService.save(productDetail);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody ProductDetail productDetail) {
        productDetailsService.delete(productDetail);
    }

    @GetMapping("/find/{id}")
    public ProductDetail findById(@PathVariable String id) {
        return productDetailsService.findById(Long.parseLong(id));
    }
}
