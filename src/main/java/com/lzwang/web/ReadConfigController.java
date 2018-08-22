package com.lzwang.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by lzwang on 2018/6/28.
 */
@RestController
@ApiIgnore
public class ReadConfigController {

    //@Value(“${属性名}”)
    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private String age;

    @RequestMapping(value="/read")
    public String index() {
        return "name:" +name + ",age:" + age;
    }
}
