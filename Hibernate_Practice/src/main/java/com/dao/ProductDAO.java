package com.dao;

import com.entity.Product;
//import com.service.ProductService;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ProductDAO extends CrudDAO<Product, Long>{
    public ProductDAO(Session session) {
        this.session = session;
    }

    @Override
    public Optional<Set<Product>> selectAll() {
        return Optional.of(
                new HashSet<>(session.createQuery("from product", Product.class).list()));
    }

    @Override
    public Optional<Product> selectById(Long id) {
        return Optional.ofNullable(session.get(Product.class, id));
    }
}
