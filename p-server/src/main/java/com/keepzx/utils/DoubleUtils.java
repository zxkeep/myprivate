package com.keepzx.utils;

public abstract class DoubleUtils {


    public static Integer add(Integer a, Integer b) {
        int ia = a == null ? 0 : a.intValue();
        int ib = b == null ? 0 : b.intValue();
        return Integer.valueOf(ia + ib);
    }


    public static Long add(Long a, Long b) {
        long ia = a == null ? 0 : a.longValue();
        long ib = b == null ? 0 : b.longValue();
        return Long.valueOf(ia + ib);
    }

    public static Long add(Integer a, Long b) {
        long ia = a == null ? 0 : a.longValue();
        long ib = b == null ? 0 : b.longValue();
        return Long.valueOf(ia + ib);
    }

    public static Long add(Long a, Integer b) {
        long ia = a == null ? 0 : a.longValue();
        long ib = b == null ? 0 : b.longValue();
        return Long.valueOf(ia + ib);
    }

    public static Integer sub(Integer a,Integer b){
        int ia = a == null ? 0 : a.intValue();
        int ib = b == null ? 0 : b.intValue();
        return Integer.valueOf(ia - ib);
    }
}
