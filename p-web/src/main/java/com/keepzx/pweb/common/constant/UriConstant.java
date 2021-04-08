package com.keepzx.pweb.common.constant;

public interface UriConstant {

    //common
    String LOGIN = "/login";
    String UPLOAD = "/upload";
    String GET_CAPTCHA = "/get-captcha";
    String LOGOUT = "/logout";

    //帐号管理
    String ACCOUNT_LIST = "/account/list";
    String ACCOUNT_ADD = "/account/add";
    String ACCOUNT_EDIT = "/account/edit";
    String ACCOUNT_DEL = "/account/del";
    String ACCOUNT_MODIFY_PASSWORD = "/account/modify/password";

    //角色管理
    String ROLE_ADD = "/role/add";
    String ROLE_PAGE = "/role/page";
    String ROLE_LIST = "/role/list";
    String ROLE_EDIT = "/role/edit";
    String ROLE_DEL = "/role/del";
    String ROLE_RELATIONS = "/role/relations";

    //菜单管理
    String MENU_PAGE = "/menu/page";
    String MENU_ADD = "/menu/add";
    String MENU_EDIT = "/menu/edit";
    String MENU_DEL = "/menu/del";

    //门店
    String PHARMACY_LIST = "/pharmacy/list";
    String PHARMACY_ADD = "/pharmacy/add";
    String PHARMACY_EDIT = "/pharmacy/edit";
    String PHARMACY_DEL = "/pharmacy/del";
    String PHARMCY_QRCODE = "/pharmacy/qrcode";
    String PHARMACY_PUBLIC_QRCODE = "/pharmacy/public/qrcode";



    String ORDER_INFO = "/order/info";
    String ORDER_COUPON_LIST = "/order/couponList";
    String ORDER_NUM = "/order/num";
    String ORDER_UPDATE_STATUS = "/order/update/status";
    String ORDER_RECIPE_INFO = "/order/recipe/info";
    String ORDER_CHECKMEMBERCOUPON="/order/checkMemberCoupon";
    String ORDER_LIST = "/order/list";
    String ORDER_SUBMIT = "/order/submit";
    String ORDER_EDIT = "/order/edit";
    String ORDER_DETAIL_QRCODE = "/order/detail/qrcode";
    String ORDER_PAYMENT_QRCODE = "/order/payment/qrcode";
    String ORDER_SEND_WAIT_PLAY_SMS = "/order/send/wait/play/sms";//发送订单待支付短信 和小程序通知
    String ORDER_LOGISTIC="/order/logistic";
    String ORDER_DOCTOR = "/order/doctor";
    //取消美团
    String ORDER_CANCELMT="/order/cancelmt";
    //重新预约美团/顺丰同城
    String ORDER_RECREATEMT="/order/recreatemt";
    //查看美团
    String ORDER_QUERYMT="/order/querymt";
    //
    String ORDER_QUERY_SHUNFENG="/order/query/shunfeng";
    //查询达达物流
    String ORDER_QUERY_DADA="/order/query/dada";
    //查询京东同城物流
    String ORDER_QUERYJD="/order/queryjd";
    //查询达达取消快递原因
    String ORDER_DADA_CANCEL_REASON="/order/dada/cancel/reason";

    //员工
    String EMPLOYEE_LIST = "/employee/list";
    String EMPLOYEE_TOOGLE_DELETE = "/employee/toogle/delete";
    String EMPLOYEE_EDIT = "/employee/edit";
    String EMPLOYEE_ADD = "/employee/add";
    String EMPLOYEE_EXIST = "/employee/exist";
    String EMPLOYEE_INFO = "/employee/info";
    String EMPLOYEE_QRCODE = "/employee/qrcode";
    String EMPLOYEE_PUBLIC_QRCODE = "/employee/public/qrcode";
    String EMPLOYEE_CHRONIC_QRCODE = "/employee/chronic/qrcode";
    String EMPLOYEE_DELETE_QRCODE = "/employee/delete/qrcode";
    String EMPLOYEE_APP_QRCODE = "/employee/app/qrcode";

    //商品分类
    String CATEGORY_LIST = "/category/list";
    String CATEGORY_UPDATE = "/category/update";
    String CATEGORY_ADD = "/category/add";
    String CATEGORY_DEL = "/category/del";
    String CATEGORY_INFO = "/category/info";
    String CATEGORY_LEVEL = "/category/level";
    String CATEGORY_LEVEL_LIST = "/category/level/list";
    String CATEGORY_EDIT = "/category/edit";
    String CATEGORY_DELMEDICINE = "/category/delmedicine";
    String CATEGORY_ADDMEDICINE = "/category/addmedicine";

    //药品
    String MEDICINE_LIST = "/medicine/list";
    String MEDICINE_DETAIL = "/medicine/detail";
    String MEDICINE_UPORDOWN = "/medicine/upordown";
    String MEDICINE_EDIT="/medicine/addoredit";
    String MEDICINE_EDITPRICEANDSTOCK = "/medicine/editpriceandstock";
    String MEDICINE_SALE = "/medicine/sale";
    String MEDICINE_IMPORTSTOCK="/medicine/importMedicineStock";
    String MEDICINE_IMPORTPRICE="/medicine/importMedicinePrice";
    String MEDICINE_BATCH_UPDATE_PRICE_LIST = "/medicine/batch/update/price/list";
    String MEDICINE_BATCH_UPDATE_PRICE = "/medicine/batch/update/price";


    //会员
    String USER_LIST = "/user/list";
    String USER_INFO = "/user/info";
    String USER_FROZEN = "/user/frozen";
    String USER_EDIT = "/user/edit";
    String USER_BYPHONE = "/user/byphone";

    String MEMBER_LIST="/member/list";
    String MEMBER_FROZEN="/member/frozen";
    String MEMBER_INFO="member/info";
    String MEMBER_EDIT="member/edit";

    //选择区域
    String AREA_LIST = "/area/list";

    //选择快递
    String EXPRESS_LIST = "/express/list";
    String EXPRESS_LIST_ALL = "/express/list/all";

    //医院列表
    String HOSPITAL_SEND_LIST = "/hospital/send/list";

    //奥博克订单划价相关
    String ABACUS_ORDER_CREATE = "/abacus/order/create";

    //热搜
    String HOTSEARCH_ADDOREDIT = "/hotsearch/addoredit";
    String HOTSEARCH_LIST = "/hotsearch/list";
    String HOTSEARCH_DEL = "/hotsearch/del";

    //活动列表
    String ACTIVITY_ADD = "/activity/add";
    String ACTIVITY_LIST = "/activity/list";
    String ACTIVITY_EDIT = "/activity/edit";

    // 报表相关
    String REPORT_LIST = "/report/list";
    String REPORT_GET = "/report/get";
    String REPORT_DETAIL = "/report/detail";
    String REPORT_EXPORT = "/report/export";
    String REPORT_COLLECT = "/report/collect";
    String REPORT_CANCEL_COLLECT = "/report/cancel/collect";


    String EXPRESS_QUERY = "/express/query";

    String POSTAGE_SELECT="postage/select";

    String DATA_SHOW="data/show";
    String DATA_STORE="data/store";
    String DATA_RANK="data/rank";
    String DATA_EXPORT="data/export";

    public static void main(String[] args) {
        System.out.println("group1/M00/01/49/rBCqcVs0ds-AUEi_AACzTYbmr30178.jpg".length());
    }
}
