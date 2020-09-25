package com.practice.crudproduct.repository;

import com.practice.crudproduct.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetail, Long> {
}
