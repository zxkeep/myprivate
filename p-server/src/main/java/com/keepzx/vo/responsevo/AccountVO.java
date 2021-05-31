package com.keepzx.vo.responsevo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author keep-zx
 * @version 1.0.0
 * @create 2021-05-31 15:43
 * @desc 账户类vo
 */
@Data
public class AccountVO implements Serializable {
    private static final long serialVersionUID = -6750833041564826938L;

    private Integer accountId;          //用户Id
    private String accountLoginName;    //用户登录名  1
    private Date createDatetime;        //创建时间
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String password;            //用户登录密码
    private String newPassword;            //新密码 （修改密码时使用）
    private String confirmPassword;            //确认密码 （新增用户 或者 修改密码时使用）

    private Integer pageIndex;                   //页码
    private Integer pageSize;                   //每页容量


}
