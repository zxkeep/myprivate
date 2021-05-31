package com.keepzx.vo.assembler;

import com.keepzx.domain.entity.Account;
import com.keepzx.vo.LoginResult;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author keep-zx
 * @version 1.0.0
 * @create 2021-05-31 15:53
 * @desc 装换类
 */
public class LoginAssembler {

    public static LoginResult toVo(Account account) {
        LoginResult loginResult = new LoginResult();
        loginResult.setAccountLoginName(account.getAccLoginName());
        loginResult.setAccountId(account.getId());
        return loginResult;

    }

}