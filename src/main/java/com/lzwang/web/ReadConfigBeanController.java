package com.lzwang.web;

import com.lzwang.bean.ConfigBean;
import com.lzwang.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by lzwang on 2018/6/28.
 */
@EnableConfigurationProperties({ConfigBean.class, User.class})
@RestController
@ApiIgnore
public class ReadConfigBeanController {

    @Autowired
    private ConfigBean configBean;

    @Autowired
    private User user;

    @RequestMapping(value="/readBean")
    public String index() {
        return configBean.getName()+" >>>>"+configBean.getAge();
    }

    @RequestMapping(value="/readUser")
    public String readUser() {
        return user.getName()+" >>>>"+user.getAge();
    }
}
