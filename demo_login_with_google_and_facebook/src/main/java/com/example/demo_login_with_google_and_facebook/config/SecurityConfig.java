package com.example.demo_login_with_google_and_facebook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "signup", "login", "/logout").permitAll()
                .antMatchers("/userInfo").hasRole("ROLE_USER")
                .antMatchers("/admin").hasRole("ROLE_ADMIN")
                .and().exceptionHandling().accessDeniedPage("/403")
                .and().formLogin().loginPage("/login").defaultSuccessUrl("userInfo");
//        http.apply(new SpringSocialConfigurer()).signupUrl("/signup");
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return userDetailsService;
    }
}
