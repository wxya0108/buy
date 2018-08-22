package com.buy.service;

import com.buy.entity.User;

import java.util.List;

/**
 * Created by win7 on 2018/7/30.
 */
public interface IUserService {
    int addUser(User user);

    int editUser(User user);

    int delUser(int id);

    User getUser(int id);

    List<User> findUser(String name,int pageIndex);
}
