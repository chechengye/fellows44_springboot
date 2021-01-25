package com.weichuang.fellows44_springboot.service;

import com.weichuang.fellows44_springboot.pojo.Employee;

public interface EmployeeService {
    Employee getEmployeeById(Integer id);

    Employee updateEmployeeById(Employee employee);

    void deleteEmployeeById(Integer id);
}
