package com.practice.crudproduct.service;

import com.practice.crudproduct.entity.UserDetail;
import com.practice.crudproduct.exception.UserNotFoundException;
import com.practice.crudproduct.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements CrudService<UserDetail, Long>{
    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    UserService userService;

    @Override
    public UserDetail save(UserDetail userDetail) {
        userDetail.setUser(userService.findById(userDetail.getId()));
        return userDetailsRepository.save(userDetail);
    }

    @Override
    public UserDetail findById(Long aLong) {
        return userDetailsRepository.findById(aLong).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void deleteById(Long aLong) {
        userDetailsRepository.deleteById(aLong);
    }

    @Override
    public void delete(UserDetail userDetail) {
        userDetailsRepository.delete(userDetail);
    }
}