package com.keepzx.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author keep-zx
 * @version 1.0.0
 * @create 2021-05-31 15:43
 * @desc 登陆返回类
 */
@Data
public class LoginResult implements Serializable {

    private static final long serialVersionUID = 6848021465604548152L;
    private String accountLoginName; //账户姓名
    private Integer accountId; //账户id


}
