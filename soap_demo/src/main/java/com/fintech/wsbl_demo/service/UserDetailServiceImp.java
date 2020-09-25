package com.fintech.wsbl_demo.service;

import com.fintech.wsbl_demo.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.User.*;

import static org.springframework.security.core.userdetails.User.withUsername;

@Component
public class UserDetailServiceImp implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = findUserByUserName(userName);
        UserBuilder builder = null;
        if (user != null) {
            builder = withUsername(userName);
            builder.password(user.getPassword());
            builder.roles(user.getRole());
        } else {
            throw new UsernameNotFoundException("user not found.");
        }
        return builder.build();
    }

    private User findUserByUserName(String userName) {
        if (userName.equalsIgnoreCase("admin")) {
            return new User(userName, "password", "ADMIN");
        }
        return null;
    }
}
