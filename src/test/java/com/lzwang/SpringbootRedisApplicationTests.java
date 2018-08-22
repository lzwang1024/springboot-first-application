package com.lzwang;

import com.lzwang.dao.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by lzwang on 2018/7/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

    public static Logger logger= LoggerFactory.getLogger(SpringbootRedisApplicationTests.class);

    @Autowired
    RedisDao redisDao;

    @Test
    public void testRedis(){
//        redisDao.setKey("name","lzwang");
//        redisDao.setKey("age","11");
        logger.info(redisDao.getValue("name"));
        logger.info(redisDao.getValue("age"));
    }

}
