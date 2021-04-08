package com.keepzx.constant;

public enum Indicator {
    // 通用状态
    VALID_IND_YES(1, "有效"), VALID_IND_NO(2, "无效"),
    // 通用性别
    COMMON_SEX_MAN(1, "男"), COMMON_SEX_WOMAN(2, "女"), COMMON_SEX_UNKNOW(3, "未知"),
    // 通用是否
    COMMON_YES(1, "是"), COMMON_NO(2, "否") // 通用是否
    ;

    private int code;

    private String label;

    Indicator(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }


}
