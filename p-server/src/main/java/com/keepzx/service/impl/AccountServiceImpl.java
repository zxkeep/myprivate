package com.keepzx.service.impl;

import com.keepzx.domain.entity.Account;
import com.keepzx.mapper.base.AccountMapper;
import com.keepzx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author keep-zx
 * @version 1.0.0
 * @create 2021-05-31 15:50
 * @desc 账户实现impl
 */
@Service
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void setBaseMapper() {
        super.setBaseMapper(accountMapper);
    }
}