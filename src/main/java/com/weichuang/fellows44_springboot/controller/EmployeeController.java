package com.weichuang.fellows44_springboot.controller;

import com.weichuang.fellows44_springboot.pojo.Employee;
import com.weichuang.fellows44_springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.pkcs11.P11Util;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService es;

    @GetMapping("/getEmployeeById")
    public Employee getEmployeeById(Integer id){
        return es.getEmployeeById(id);
    }

    @PostMapping("/updateEmployeeById")
    public Employee updateEmployeeById(Employee employee){
        es.updateEmployeeById(employee);
        return employee;
    }

    @PostMapping("/deleteEmployeeById")
    public void deleteEmployeeById(Integer id){
        es.deleteEmployeeById(id);
    }
}
