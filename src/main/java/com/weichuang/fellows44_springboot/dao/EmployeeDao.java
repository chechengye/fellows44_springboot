package com.weichuang.fellows44_springboot.dao;

import com.weichuang.fellows44_springboot.pojo.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeDao {

    @Select("select * from ems_employee where id = #{id}")
    Employee getEmployeeById(Integer id);
}
