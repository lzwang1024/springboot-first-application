package com.lzwang.service;

import com.lzwang.bean.Account;

import java.util.List;

/**
 * Created by lzwang on 2018/6/29.
 */
public interface IAccountService {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();

    void testTransaction();
}
