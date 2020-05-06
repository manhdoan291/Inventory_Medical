package com.java1906.climan.services.impl;

import com.java1906.climan.data.model.UserInfo;
import com.java1906.climan.data.repo.UserInfoRepository;
import com.java1906.climan.services.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public Optional<UserInfo> get(Integer id) {
        return userInfoRepository.findById(id);
    }

    @Override
    public List<UserInfo> getAll() {
        return (List<UserInfo>) userInfoRepository.findAll();
    }

    @Override
    public void post(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }

    @Override
    public void put(UserInfo userInfo, Integer id) {
        userInfoRepository.findById(id);
        userInfoRepository.save(userInfo);
    }

    @Override
    public void delete(Integer id) {
        userInfoRepository.deleteById(id);
    }
}
