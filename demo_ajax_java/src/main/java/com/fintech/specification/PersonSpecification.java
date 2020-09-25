package com.fintech.specification;

import com.fintech.domain.Person;
import com.fintech.domain.Status;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class PersonSpecification {
    private final List<Specification<Person>> personSpecs = new ArrayList<>();

    public static PersonSpecification spec() {
        return new PersonSpecification();
    }

    public PersonSpecification byName(String name) {
        personSpecs.add(hasApproveFirstName(name).or(hasApproveLastName(name)));
        return this;
    }

    public PersonSpecification byStatus(Status status) {
        personSpecs.add(hasApproveStatus(status));
        return this;
    }

    public Specification<Person> build() {
        Specification<Person> sp = personSpecs.stream().reduce(all(), Specification::and);
        return Specification.where(sp);
    }

    public Specification<Person> hasApproveFirstName(String firstName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("firstName"), "%" + firstName + "%");
    }

    public Specification<Person> hasApproveLastName(String lastName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("lastName"), "%" + lastName + "%");
    }

    public Specification<Person> hasApproveStatus(Status status) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), status);
    }

    public Specification<Person> all() {
        return Specification.where(null);
    }
}
