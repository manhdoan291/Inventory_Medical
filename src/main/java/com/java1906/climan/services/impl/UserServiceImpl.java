package com.java1906.climan.services.impl;

import com.java1906.climan.data.model.User;
import com.java1906.climan.data.repo.UserRepository;
import com.java1906.climan.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User get(Integer id) {
        return null;
    }

    @Override
    public List<Integer> getAll() {
        return null;
    }

    @Override
    public void post(User user) {

    }

    @Override
    public void put(User user, Integer id) {

    }

    @Override
    public void delete(Integer id) {

    }
}
