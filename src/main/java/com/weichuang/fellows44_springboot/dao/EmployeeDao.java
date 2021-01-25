package com.weichuang.fellows44_springboot.dao;

import com.weichuang.fellows44_springboot.pojo.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EmployeeDao {

    @Select("select * from ems_employee where id = #{id}")
    Employee getEmployeeById(Integer id);

    @Update("update ems_employee set name = #{name} , email = #{email} where id = #{id}")
    void updateEmployeeById(Employee employee);

    @Delete("delete from ems_employee where id = #{id}")
    void deleteEmployeeById(Integer id);
}
