package com.lzwang.service.impl;

import com.lzwang.bean.Account;
import com.lzwang.dao.AccountMapper2;
import com.lzwang.dao.IAccountDao;
import com.lzwang.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lzwang on 2018/6/29.
 */
@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDAO;

    @Autowired
    private AccountMapper2 accountMapper2;

    @Override
    public int add(Account account) {
        return accountDAO.add(account);
    }

    @Override
    public int update(Account account) {
        return accountDAO.update(account);
    }

    @Override
    public int delete(int id) {
        return accountDAO.delete(id);
    }

    @Override
    public Account findAccountById(int id) {
        return accountDAO.findAccountById(id);
    }

    @Override
    public List<Account> findAccountList() {
        return accountDAO.findAccountList();
    }

    @Override
    @Transactional
    public void testTransaction() {
        accountMapper2.update(1,90);
        int i=1/0;// 此处会有异常，开启事务，可保证数据一致性。
        accountMapper2.update(2,110);
    }
}
