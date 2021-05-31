package com.keepzx.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.keepzx.constant.Indicator;
import com.keepzx.domain.bean.AccountBean;
import com.keepzx.domain.entity.Account;
import com.keepzx.mapper.base.AccountMapper;
import com.keepzx.service.AccountService;
import com.keepzx.utils.DesUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public Page<AccountBean> getAccountRole(AccountBean accountBean) {
        Integer pageIndex = accountBean.getPageIndex();
        Integer pageSize = accountBean.getPageSize();
        Page<AccountBean> page = PageHelper.offsetPage((pageIndex-1)*pageSize,pageSize,true);
//        accountBeanMapper.selectAccount(accountBean);
        return page;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation= Isolation.DEFAULT,rollbackFor=Exception.class)
    public void addAccount(AccountBean accountBean) {
        accountMapper.insertSelective(accountBean);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation= Isolation.DEFAULT,rollbackFor=Exception.class)
    public void deleteAccount(List<Integer> accountIdList,
                              Integer updateUser) {
        for(Integer accId:accountIdList){
            Account account = accountMapper.selectByPrimaryKey(accId);
            if(null == account){
                account.setUpdateUser(updateUser);
                account.setDataDelete(Indicator.COMMON_YES.getCode());
                accountMapper.updateByPrimaryKey(account);
            }
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation= Isolation.DEFAULT,rollbackFor=Exception.class)
    public void updateAccount(AccountBean accountBean) {
        String encodeNerPwd = DesUtils.encodeWithSha1(accountBean.getNewPassword());
        String encodeOldPwd = DesUtils.encodeWithSha1(accountBean.getAccPassword());
        Account account = accountMapper.selectByPrimaryKey(accountBean.getId());
        if (!account.getAccPassword().equals(encodeOldPwd)){
            throw new RuntimeException("原密码输入错误！");
        }
        account.setAccPassword(encodeNerPwd);
        accountMapper.updateByPrimaryKey(account);
    }

}