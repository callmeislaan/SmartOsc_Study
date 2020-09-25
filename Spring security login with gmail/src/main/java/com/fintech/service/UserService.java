package com.fintech.service;

import com.fintech.entity.User;
import com.fintech.repository.RoleRepository;
import com.fintech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public User saveUser(User user) {
        if (user.getRoles() == null) {
            user.getRoles().add(roleRepository.findByName("MEMBER"));
        }
        return userRepository.save(user);
    }
}
