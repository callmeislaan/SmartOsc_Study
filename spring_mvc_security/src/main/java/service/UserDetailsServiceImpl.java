package service;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.*;
import repository.UserRepository;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = findUserByName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }
        UserBuilder builder = withUsername(userName);
        builder.password(user.getPassword());
        builder.roles(user.getRole());
        return builder.build();
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    private User findUserByName(String userName) {
        if (userName.equalsIgnoreCase("user")) {
            return new User(userName, passwordEncoder.encode("password"), "ADMIN");
        }
        return null;
    }
}
