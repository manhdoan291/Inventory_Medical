package com.java1906.demointerceptor.data.model;

import org.apache.tomcat.util.security.MD5Encoder;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String email;
    private String password;

    @PrePersist
    @PreUpdate
    public void preSave() {
        password = MD5Encoder.encode((password + "this is a salt 3l;3k;j08293nu9p2g5n").getBytes());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}