package com.keepzx.utils;

import java.util.Date;
import java.util.Random;

public class NumberUtils {

    public final static int ORDER_TYPE = 1;
    public final static int ORDER_TYPE_PLAT = 2;
    public final static int ORDER_TYPE_STORE = 3;
    public final static int ORDER_TYPE_ABACUS = 4;
    public final static int ORDER_TYPE_REFUND = 5;
    public final static int COUPON_SECKILL_PAY = 6;
    public final static int ORDER_TYPE_DTP_ABACUS = 7;
    public final static int ORDER_REFUND = 8;
    public final static int ORDER_TYPE_VIP = 9;

    public static String getOrderNumber(int type, int phaId) {
        Random random = new Random();
        int randomNumber = random.nextInt(999999);
        if (randomNumber < 100000) {
            randomNumber = randomNumber + 100000;
        }
        String date = DateUtils.getFormatDateStr(new Date(), "yyMMddHH");
        return type + phaId + date + randomNumber;
    }
    public static String getDtpOrderNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(999);
        if (randomNumber < 100) {
            randomNumber = randomNumber + 100;
        }
        String date = DateUtils.getFormatDateStr(new Date(), "yyMMdd");
        return date + randomNumber;
    }

    //随机生成六位数
    public static String getNumber() {
        Random random = new Random();
        Integer randomNumber = random.nextInt(999999);
        if (randomNumber < 100000) {
            randomNumber = randomNumber + 100000;
        }
        return randomNumber.toString();
    }

    public static String getRecipeNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(999);
        if (randomNumber < 100) {
            randomNumber = randomNumber + 100;
        }
        String date = DateUtils.getFormatDateStr(new Date(), "yyyyMMddHHmmss");
        return date + randomNumber;
    }



    public static void main(String[] args) {
        String recipeNumber = getRecipeNumber();
        System.out.println(recipeNumber);
    }
}
