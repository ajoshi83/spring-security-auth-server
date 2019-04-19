package com.poc.springboot.springsecurityauthserver.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "app_user")
@Data
public class AppUser {
    @Id
    @Column
    private String userEmail;

    @Column
    private String userPass;

    @Column
    private String userRole;
}
