package com.practice.crudproduct.service;

import com.practice.crudproduct.entity.User;
import com.practice.crudproduct.exception.UserNotFoundException;
import com.practice.crudproduct.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements CrudService<User, Long> {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public User save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findById(Long aLong) {
        return userRepository.findById(aLong).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
