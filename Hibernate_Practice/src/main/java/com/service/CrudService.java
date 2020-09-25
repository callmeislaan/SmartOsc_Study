package com.service;

import com.dao.CrudDAO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Optional;
import java.util.Set;

public class CrudService<T>{
    protected Session session;
    protected CrudDAO<T, Long> crudDAO;
    
    public T insert(T t) {
        Transaction transaction = null;
        Optional<T> optionalT = Optional.empty();
        try {
            transaction = session.beginTransaction();
            optionalT = crudDAO.insert(t);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
        return optionalT.orElseThrow(() -> new TException("insert field!"));
    }

    public Set<T> selectAll(){
        return crudDAO.selectAll().orElseThrow(() -> new TException("select all field!"));
    }

    public boolean delete(T t) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            crudDAO.delete(t);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            throw new TException("delete field!");
        }
    }

    
    public T selectById(Long id){
        return crudDAO.selectById(id).orElseThrow(() -> new TException("select by id field!"));
    }

    
    public T update(T t){
        Transaction transaction = null;
        T tResult = null;
        try {
            transaction = session.beginTransaction();
            tResult = crudDAO.update(t)
                    .orElseThrow(() -> new TException("update field!"));
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null)
                transaction.rollback();
            ex.printStackTrace();
        }
        return tResult;
    }

    public static class TException extends RuntimeException {
        public TException(String message) {
            super(message);
        }
    }
}
