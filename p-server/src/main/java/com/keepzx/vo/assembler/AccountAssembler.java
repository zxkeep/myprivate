package com.keepzx.vo.assembler;

import com.keepzx.constant.Indicator;
import com.keepzx.constant.Page;
import com.keepzx.domain.bean.AccountBean;
import com.keepzx.domain.entity.Account;
import com.keepzx.utils.DesUtils;
import com.keepzx.vo.responsevo.AccountVO;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author keep-zx
 * @version 1.0.0
 * @create 2021-05-31 15:53
 * @desc 装换类
 */
public class AccountAssembler {

    public static AccountVO bean2vo(AccountBean accountBean) {
        AccountVO accountVO = new AccountVO();
        accountVO.setAccountId(accountBean.getId());
        accountVO.setAccountLoginName(accountBean.getAccLoginName());
        accountVO.setCreateDatetime(accountBean.getCreateDatetime());
        return accountVO;
    }
    public static AccountVO entity2vo(Account account) {
        AccountVO accountVO = new AccountVO();
        accountVO.setAccountId(account.getId());
        accountVO.setAccountLoginName(account.getAccLoginName());
        accountVO.setCreateDatetime(account.getCreateDatetime());
        return accountVO;
    }

    public static Page<AccountVO> page2vo(com.github.pagehelper.Page<AccountBean> accountBeanPage) {
        Page<AccountVO> accountVOPage = new Page<>();
        accountVOPage.setPageIndex(accountBeanPage.getPageNum());
        accountVOPage.setPageSize(accountBeanPage.getPageSize());
        accountVOPage.setTotalElements(accountBeanPage.getTotal());
        List<AccountVO> roleVOList = accountBeanPage.getResult().stream()
                .map(AccountAssembler::bean2vo)
                .collect(Collectors.toList());
        accountVOPage.setData(roleVOList);
        return accountVOPage;

    }

    public static AccountBean vo2bean(AccountVO accountVO) {
        AccountBean accountBean = new AccountBean();
        accountBean.setId(accountVO.getAccountId());
        accountBean.setAccLoginName(accountVO.getAccountLoginName());
        String s = DesUtils.encodeWithSha1(accountVO.getPassword());
        accountBean.setAccPassword(s);
        accountBean.setDataDelete(Indicator.COMMON_NO.getCode());
        accountBean.setPageIndex(accountVO.getPageIndex());
        accountBean.setPageSize(accountVO.getPageSize());
        return accountBean;
    }

    public static List<AccountBean> vo2bean(List<AccountVO> accountVOList) {
        if (CollectionUtils.isEmpty(accountVOList)) {
            return Collections.emptyList();
        }
        return accountVOList.stream()
                .map(AccountAssembler::vo2bean)
                .collect(Collectors.toList());
    }

}
