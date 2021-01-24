package com.weichuang.fellows44_springboot.controller;

import com.weichuang.fellows44_springboot.pojo.User;
import com.weichuang.fellows44_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @RestController : 是SpringBoot中的注解，是一个组合注解，同时包含了
 *     @Controller ： 标识controller层的。给springmvc的前端控制器查询用
 *     @ResponseBody ： 将对象类型转为json
 *  @PostMapping("/路由")
 *  @GetMapping"/路由")
 *      以上两种注解与@RequestMapping配置都是一直的
 *
 */
@RestController
public class UserController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserService userService;
    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return jdbcTemplate.query("select * from ums_user", new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setEmail(rs.getString("email"));
               return user;
            }
        });
    }

    @GetMapping("/getUserById")
    public User getUserById(Integer id){
        return userService.getUserById(id);
    }
    @PostMapping("/updateUserById")
    public User updateUserById(User user){
        int rows = userService.updateUserById(user);
        return user;
    }

}
