package com.weichuang.fellows44_springboot.dao;

import com.weichuang.fellows44_springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

//@Mapper : SpringBoot中要求Mybatis的接口要标识的注解
public interface UserDao {
    User getUserById(Integer id);

    //注解版的sql编写。更推荐使用xml文件，动态sql的方式进行编写
    @Update("update ums_user set name = #{name} where id = #{id}")
    int updateUserById(User user);
}
