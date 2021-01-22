package com.weichuang.fellows44_springboot.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *  @Value 与 @ConfigurationProperties 区别
 *  1、前者一个一个赋值，后者可批量赋值
 *  2、前者不支持松散绑定，后者支持
 *  3、前者支持SPEL表达式，后者不支持
 *  4、JSR303校验@Validated，前者不支持，后者支持
 *  5、复杂类型封装比如map，前者不支持 ，后者支持
 */
@ConfigurationProperties(prefix = "person")
@Component
@Validated
public class Person implements Serializable{

    @Value("赵六")
    private String name;
    @Value("#{11+22}")
    private int age;
    private List list;
    private Map map;
    @Value("${person.birthday}")
    private Date birthday;
    private Car car;
    private String lastName;

    @Email
    private String email;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", list=" + list +
                ", map=" + map +
                ", birthday=" + birthday +
                ", car=" + car +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
