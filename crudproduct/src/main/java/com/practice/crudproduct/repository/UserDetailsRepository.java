package com.practice.crudproduct.repository;

import com.practice.crudproduct.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetail, Long> {

}