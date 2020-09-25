package com.dao;

import org.hibernate.Session;

import java.util.Optional;
import java.util.Set;

public abstract class CrudDAO<T, K> {
    protected Session session;

    abstract public Optional<Set<T>> selectAll();
    abstract public Optional<T> selectById(K id);

    public Optional<T> insert(T t) {
        session.persist(t);
        return Optional.ofNullable(t);
    }

    public Optional<T> insertById(K id) {
        return Optional.empty();
    }

    public Optional<T> update(T t) {
        session.update(t);
        return Optional.of(t);
    }

    public void delete(T t) {
        session.delete(t);
    }
}