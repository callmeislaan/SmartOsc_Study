package com.fintech.specification;

import com.fintech.domain.Person;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonSpecification {

   private final List<Specification<Person>> personSpecifications = new ArrayList<>();

   public static PersonSpecification spec() {
       return new PersonSpecification();
   }

   public Specification<Person> hasByFirstName(String firstName) {
       return (root, query, criteriaBuilder) ->
               criteriaBuilder.like(root.get("firstName"), "%" + firstName + "%");
   }

   public Specification<Person> hasByLastName(String lastName) {
       return (root, query, criteriaBuilder) ->
               criteriaBuilder.like(root.get("lastName"), "%" + lastName + "%");
   }

   public PersonSpecification byName(String name) {
       personSpecifications.add(hasByLastName(name).or(hasByFirstName(name)));
       return this;
   }

   public PersonSpecification byStatus(Person.Status status) {
       personSpecifications.add((root, query, criteriaBuilder) ->
               criteriaBuilder.equal(root.get("status"), status));
       return this;
   }

   public Specification<Person> build() {
       Specification<Person> sp = personSpecifications.stream().reduce(all(), Specification::and);
       return Specification.where(sp);
   }

    private Specification<Person> all() {
        return Specification.where(null);
    }

}
