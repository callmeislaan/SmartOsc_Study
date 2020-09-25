package com.practice.crudproduct.service;

public interface CrudService<T, K> {

    T save(T t);

    T findById(K k);

    void deleteById(K k);

    void delete(T t);
}
