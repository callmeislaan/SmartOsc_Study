package com.fintech.repository;

import com.fintech.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface PersonRepositoryJpa extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {
}
