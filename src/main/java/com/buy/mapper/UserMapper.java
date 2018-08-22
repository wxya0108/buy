package com.buy.mapper;

import com.buy.entity.User;
import com.buy.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends MyMapper<User> {
    int insert(User user);

    int update(User user);

    int del(int id);

    User get(int id);

    List<User> findUser(@Param("name")String name);
}