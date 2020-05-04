package com.java1906.climan.data.repo;

import com.java1906.climan.data.model.UserInfo;
import com.java1906.climan.data.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo, User> {

}
