package com.java1906.demointerceptor.data.repo;

import com.java1906.demointerceptor.data.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Users, Integer> {
    public Optional<Users> findByUsername(String username);
}