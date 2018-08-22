package com.lzwang.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lzwang on 2018/7/4.
 */
@Mapper
public interface AccountMapper2 {
    int update(@Param("id")int id, @Param("money")double money);
}
