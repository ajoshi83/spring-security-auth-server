package com.poc.springboot.springsecurityauthserver.service;

import com.poc.springboot.springsecurityauthserver.entity.AuthUserDetail;
import com.poc.springboot.springsecurityauthserver.entity.User;
import com.poc.springboot.springsecurityauthserver.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final Optional<User> optionalUser = userDetailsRepository.findByUsername(username);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Invalid credentials"));

        UserDetails userDetails = new AuthUserDetail(optionalUser.get());
        new AccountStatusUserDetailsChecker().check(userDetails);

        return userDetails;
    }
}