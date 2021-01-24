package com.weichuang.fellows44_springboot.service;

import com.weichuang.fellows44_springboot.pojo.User;

public interface UserService {
    User getUserById(Integer id);

    int updateUserById(User user);
}
