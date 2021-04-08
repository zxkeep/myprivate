package com.keepzx.pweb.common.constant;

public enum ResponseConstant {

    OPERATION_SUCCESS("0000", "操作成功"),
    OPERATION_FAIL("0001", "操作失败"),
    OPERATION_WRONG_CAPTCHA_CODE("0002", "验证码错误"),
    OPERATION_WRONG_PARAM("0003", "参数错误"),
    OPERATION_WITHOUT_LOGIN("0004", "尚未登录"),
    OPERATION_LOGIN_FAIL("0005", "用户名或密码错误！"),
    OPERATION_NO_STOCK("0006", "订单中有库存不足商品"),
    OPERATION_TAG_EXIST("0007", "该标签已经存在"),
    OPERATION_CATEGORY_EXIST("0008", "该商品分类已经存在"),
    OPERATION_EMP_NUMBER_EXIST("0009", "该编号的员工已经存在"),
    OPERATION_USER_NUMBER_EXIST("0010", "该编号的用户已经存在"),
    OPERATION_NO_MEDICINE("0011", "订单中没有商品"),
    OPERATION_OLD_PASSWORD_FAIL("0012", "旧密码错误"),
    OPERATION_ROLE_NAME_EXIST("0013", "该名字的角色已经存在"),
    OPERATION_WRONG_ORDER("0014", "无效订单"),
    OPERATION_WRONG_ORDER_ABACUS("0015", "已划价"),
    OPERATION_ACTIVITY_NAME_EXIST("0016", "该门店活动类型已经存在"),
    ACC_DOCTOR_NAME_EMPTY("0017", "请到用户管理完善审核药师名字"),
    ORDER_NO_PAYMENT("0018", "请将状态切回等待支付，并提示客户支付该订单"),
    SYSTERM_EXCEPT("1000", "系统异常");

    private String code;
    private String message;

    ResponseConstant(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
