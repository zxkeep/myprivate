package com.keepzx.domain.bean;

import com.keepzx.domain.entity.Account;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author keep-zx
 * @version 1.0.0
 * @create 2021-05-31 20:23
 * @desc 账户bean
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AccountBean extends Account {


    private String newPassword;            //新密码 （修改密码时使用）
    private String confirmPassword;            //确认密码 （新增用户 或者 修改密码时使用）

    Integer pageIndex;                  //页码
    Integer pageSize;                   //每页容量


}
