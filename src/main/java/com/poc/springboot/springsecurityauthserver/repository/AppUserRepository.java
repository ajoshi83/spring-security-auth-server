package com.poc.springboot.springsecurityauthserver.repository;

import com.poc.springboot.springsecurityauthserver.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {}
