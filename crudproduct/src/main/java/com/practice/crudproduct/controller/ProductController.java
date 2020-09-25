package com.practice.crudproduct.controller;

import com.practice.crudproduct.entity.Product;
import com.practice.crudproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Product product) {
        productService.delete(product);
    }

    @GetMapping("/find/{id}")
    public Product findById(@PathVariable String id) {
        return productService.findById(Long.parseLong(id));
    }
}
