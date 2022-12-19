package com.lyj.hello;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2022-12-19 11:30
 **/
public class Person {

    String name;
    Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
