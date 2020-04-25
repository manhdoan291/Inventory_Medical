package com.java1906.demointerceptor.data.model;

import org.apache.tomcat.util.security.MD5Encoder;

import javax.persistence.*;
import java.io.Serializable;

@Entity // This tells Hibernate to make a table out of this class
@IdClass(UserInfo.class)
public class Users implements Serializable {
    @OneToOne
    @JoinColumn(name = "id")
    @Id
    private UserInfo id;
    private String username;
    private String email;
    private String password;
    private String role;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @PrePersist
    @PreUpdate
    public void preSave() {
        password = MD5Encoder.encode((password + "this is a salt 3l;3k;j08293nu9p2g5n").getBytes());
    }

    public UserInfo getId() {
        return id;
    }

    public void setId(UserInfo id) {
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