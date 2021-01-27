package com.weichuang.fellows44_springboot.controller;

import com.weichuang.fellows44_springboot.pojo.Employee;
import com.weichuang.fellows44_springboot.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.pkcs11.P11Util;

/**
 * @Api() : 标识在类上面
 *      tags/value 取名称 推荐使用tags
 *      description ： 描述信息
 * @ApiOpertation
 *      value : 对于方法的描述 - 用途，说明等
 *      notes : 备注信息
 *  @ApiImplicitParams
 *      @ApiImplicitParam : 描述参数作用，取值范围
 * @ApiModelProperty ： 描述一个属性，与数据库中的字段的注释保持一致
 */
@RestController
@Api(tags = "EmployeeController" ,description = "雇员管理类")
public class EmployeeController {

    @Autowired
    EmployeeService es;

    @ApiImplicitParam(name = "id" , value = "主键取值大于0")
    @ApiOperation(value = "根据雇员主键id获取雇员信息",notes = "id不能为空")
    @GetMapping("/getEmployeeById")
    public Employee getEmployeeById(Integer id){
        return es.getEmployeeById(id);
    }

    @ApiOperation("根据主键id更新雇员信息")
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
