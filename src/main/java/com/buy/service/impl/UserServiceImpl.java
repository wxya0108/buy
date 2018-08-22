package com.buy.service.impl;

import com.buy.entity.User;
import com.buy.mapper.UserMapper;
import com.buy.service.IUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by win7 on 2018/7/30.
 */

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int editUser(User user) {
        return userMapper.update(user);
    }

    @Override
    public int delUser(int id) {
        return userMapper.del(id);
    }

    @Override
    public User getUser(int id) {
        return userMapper.get(id);
    }

    @Override
    public List<User> findUser(String name, int pageIndex) {
        PageHelper.startPage(pageIndex,3);
        return userMapper.findUser(name);
    }


}
