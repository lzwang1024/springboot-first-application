package com.lzwang.dao;

import com.lzwang.bean.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lzwang on 2018/6/29.
 */
public interface IAccountDao {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();
}
