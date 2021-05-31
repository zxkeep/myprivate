package com.keepzx.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author keep-zx
 * @version 1.0.0
 * @create 2021-05-31 15:43
 * @desc 登陆请求类
 */
@Data
public class LoginRequest implements Serializable {

    private static final long serialVersionUID = 826350287805984352L;
    private String loginName;
    private String password;
    private String captchaCode;
    private String guId;
    private Integer phaId;

}
