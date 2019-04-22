package com.poc.springboot.springsecurityauthserver.repository;

import com.poc.springboot.springsecurityauthserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(final String username);
}
