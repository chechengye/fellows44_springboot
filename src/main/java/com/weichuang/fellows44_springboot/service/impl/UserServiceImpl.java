package com.weichuang.fellows44_springboot.service.impl;

import com.weichuang.fellows44_springboot.dao.UserDao;
import com.weichuang.fellows44_springboot.pojo.User;
import com.weichuang.fellows44_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public int updateUserById(User user) {
        return userDao.updateUserById(user);
    }
}
