package com.lzwang;

import com.lzwang.dao.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * 集成SpringCache测试
 * Created by lzwang on 2018/7/10.
 */
@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final BookRepository bookRepository;

    public AppRunner(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... strings) throws Exception {
        logger.info(".... Fetching books");
//        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
//        logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
//        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
//        logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
//        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
//        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
    }
}
