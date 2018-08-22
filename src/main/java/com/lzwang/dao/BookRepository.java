package com.lzwang.dao;

import com.lzwang.bean.Book;

/**
 * Created by lzwang on 2018/7/10.
 */
public interface BookRepository {
    Book getByIsbn(String isBn);
}
