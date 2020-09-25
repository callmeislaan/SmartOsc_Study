package com.fintech.soap_task.service;

import com.fintech.soap_task.modal.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.*;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service
public class UserDetailsServiceImp implements org.springframework.security.core.userdetails.UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = findUserByName(userName);
        UserBuilder builder = null;
        if (user != null) {
            builder = withUsername(userName);
            builder.password(user.getPassword());
            builder.roles(user.getRole());
        } else {
            throw new UsernameNotFoundException("user not found");
        }
        return builder.build();
    }

    private User findUserByName(String userName) {
        if (userName.equalsIgnoreCase("admin")) {
            return new User(userName, "password", "ADMIN");
        }
        return null;
    }
}
