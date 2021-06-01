package com.keepzx.service;

import com.github.pagehelper.Page;
import com.keepzx.domain.bean.AccountBean;
import com.keepzx.domain.entity.Account;

import java.util.List;

/**
 * @author keep-zx
 * @create 2021-05-31 15:49
 * @desc 账户service
 */
public interface AccountService extends BaseService<Account> {

    Page<AccountBean> getAccounts(AccountBean accountBean);


    void addAccount(AccountBean accountBean);

    void deleteAccount(List<Integer> accountIdList,
                       Integer updateUser);


    void updateAccount(AccountBean accountBean);
}