package com.keepzx.domain.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author keep-zx
 * @version 1.0.0
 * @create 2020-09-21 15:26
 * @desc 用户签到info
 */
@Data
public class UserSignInfo implements Serializable {
    private static final long serialVersionUID = -5058064281817547704L;
    private Date time;
    private Integer surprisePack; //是否惊喜礼包（1==是 2==否）
    private Integer signDay; //连续签到天数
    private Integer done;  //是否签到（1==是 2==否）
    private Long point; //签到获取的 积分数量 ，如果为空 则是优惠券
}