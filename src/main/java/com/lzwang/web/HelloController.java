package com.lzwang.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Collections;
import java.util.Map;

/**
 * Created by lzwang on 2018/6/28.
 */
@RestController
@ApiIgnore
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/hellorest")
    public Map<String, Object> greeting() {
        return Collections.singletonMap("message", "Hello World!");
    }

}
