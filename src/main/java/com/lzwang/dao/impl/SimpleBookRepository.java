package com.lzwang.dao.impl;

import com.lzwang.bean.Book;
import com.lzwang.dao.BookRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * 集成 Spring Cache 测试
 * Created by lzwang on 2018/7/10.
 */
@Component
public class SimpleBookRepository implements BookRepository {

    @Override
    @Cacheable("books")
    public Book getByIsbn(String isBn) {
        simulateSlowService();
        return new Book(isBn, "Some book");
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
