package com.fintech.dao;

import com.fintech.domain.Account;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Getter
@Setter
@Repository
@Transactional(rollbackFor = Exception.class)
public class AccountDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public Optional<Account> selectAccountByName(String name) {
        Query query =  sessionFactory.getCurrentSession().createQuery("from Account where name = :name");
        query.setParameter("name", name);
        return query.uniqueResultOptional();
    }

    public Optional<String> selectPasswordByName(String name) {
        Query query =  sessionFactory.getCurrentSession().createQuery("select password from Account where name = :name");
        query.setParameter("name", name);
        return query.uniqueResultOptional();
    }

    public Optional<Integer> selectStatusByName(String name) {
        Query query =  sessionFactory.getCurrentSession().createQuery("select status from Account where name = :name");
        query.setParameter("name", name);
        return query.uniqueResultOptional();
    }

    public Optional<Account> update(Account account) {
        sessionFactory.getCurrentSession().update(account);
        return Optional.ofNullable(account);
    }

    public Optional<Account> add(Account account) {
        sessionFactory.getCurrentSession().save(account);
        return Optional.ofNullable(account);
    }
}
