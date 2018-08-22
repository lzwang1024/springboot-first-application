package com.lzwang.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by lzwang on 2018/6/28.
 */
@ConfigurationProperties(prefix = "my")
public class ConfigBean {
    private String name;
    private int age;
//    private int number;
//    private String uuid;
//    private int max;
//    private String value;
//    private String greeting;

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

}
