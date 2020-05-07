package com.java1906.climan.services;

import com.java1906.climan.data.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public Optional<User> findByUsername(String username);
    public User get(Integer id);
    public List<Integer> getAll();
    public void post(User user);
    public void put(User user, Integer id);
    public void delete(Integer id);
}
