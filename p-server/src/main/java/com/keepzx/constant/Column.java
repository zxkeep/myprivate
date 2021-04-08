package com.keepzx.constant;

import java.util.LinkedHashMap;
import java.util.Map;

public enum Column {

    VALID_IND(Indicator.VALID_IND_YES, Indicator.VALID_IND_NO),
    COMMON_SEX(Indicator.COMMON_SEX_MAN, Indicator.COMMON_SEX_WOMAN, Indicator.COMMON_SEX_UNKNOW)
    ;


    private Map<Integer, String> maps = new LinkedHashMap<>();

    Column(Indicator... values) {
        for (Indicator it : values) {
            maps.put(it.getCode(), it.getLabel());
        }
    }

    public String getLabelByCode(Integer code) {
        if (code == null || code == 0) {
            return null;
        } else {
            return maps.get(code);
        }
    }

    public Map<Integer, String> getCodesAndLabels() {
        return maps;
    }

    public static void main(String[] args) {

    }
}
