package com.weichuang.fellows44_springboot.service.impl;

import com.weichuang.fellows44_springboot.dao.EmployeeDao;
import com.weichuang.fellows44_springboot.pojo.Employee;
import com.weichuang.fellows44_springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    /**
     * @Cacheable : （方法运行前执行的）。先会从缓存中查询数据，若是存在直接读取缓存。不进行方法调用。若不存在正常调用方法。
     *      调用方法之后，会将返回的数据存入缓存。
     * cacheNames/value : 为缓存组件Cache起名字（多个名字）。必要属性，二者选其一
     * key/keyGenerator : 二选一，给组件进行标识的，默认用第一个参数作为key
     * 获取第一个参数作为key： #root.args[0] ，默认 ， #id , #a0 , #p0
     * cacheManager/cacheResolver : 缓存管理器/缓存解析器，二选一。通常不需要配置，使用默认即可。自动进行适配
     * condition ： 条件判断，只会讲符合此条件的数据进行缓存。condition = "#id > 3"
     * unless : 除非什么才缓存。不满足时才缓存unless = "#result == null"
     * sync: 标记同步还是异步的true：异步 false : 同步
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "emp",condition = "#id > 1")
    @Override
    public Employee getEmployeeById(Integer id) {
        System.out.println("员工" + id + "号");
        return employeeDao.getEmployeeById(id);
    }
}
