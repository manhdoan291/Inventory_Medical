package com.java1906.climan.services;

import com.java1906.climan.data.model.UserInfo;

import java.util.List;
import java.util.Optional;

public interface IUserInfoService {
    public Optional<UserInfo> get(Integer id);
    public List<UserInfo> getAll();
    public void post(UserInfo userInfo);
    public void put(UserInfo userInfo, Integer id);
    public void delete(Integer id);
}
