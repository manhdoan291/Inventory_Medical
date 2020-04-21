package com.java1906.demointerceptor.data.repo;

import com.java1906.demointerceptor.data.model.Category;
import com.java1906.demointerceptor.data.model.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo, Integer> {

}
