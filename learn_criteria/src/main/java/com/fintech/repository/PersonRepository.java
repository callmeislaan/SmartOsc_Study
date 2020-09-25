package com.fintech.repository;

import com.fintech.domain.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional(rollbackFor = Exception.class)
// use Criteria api for query
public class PersonRepository {
    @PersistenceContext
    EntityManager entityManager;
    CriteriaBuilder builder;
    CriteriaQuery<Person> query;

    public List<Person> findAll() {
        builder = entityManager.getCriteriaBuilder();
        query = builder.createQuery(Person.class);
        Root<Person> root = query.from(Person.class);
        query.select(root);

        TypedQuery<Person> query1 = entityManager.createQuery(query);
        return  query1.getResultList();
    }

    public List<Person> findByName(String name) {
        builder = entityManager.getCriteriaBuilder();
        query = builder.createQuery(Person.class);
        Root<Person> root = query.from(Person.class);

        Predicate byLastName = builder.like(root.get("lastName"), "%" + name + "%");
        Predicate byFirstName = builder.like(root.get("firstName"), "'%" + name + "%'");
        Predicate condition = builder.or(byFirstName, byLastName);

        query.select(root).where(condition);
        TypedQuery<Person> query1 = entityManager.createQuery(query);
        return  query1.getResultList();
    }

    public List<Person> findByNameAndStatus(String name, Person.Status status) {
        builder = entityManager.getCriteriaBuilder();
        query = builder.createQuery(Person.class);
        Root<Person> root = query.from(Person.class);

        Predicate byLastName = builder.like(root.get("lastName"), "%" + name + "%");
        Predicate byFirstName = builder.like(root.get("firstName"), "%" + name + "%");
        Predicate byStatus = builder.equal(root.get("status"), status);
        Predicate byName = builder.or(byFirstName, byLastName);
        Predicate condition = builder.and(byName, byStatus);

        query.select(root).where(condition);

        return entityManager.createQuery(query).getResultList();
    }
}
