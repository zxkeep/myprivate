package com.scxinglin.utils;

import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 百度api 计算两个经纬度之间的驾车距离
 * @author zhengxu
 * @create 2019-04-08
 */
public class BaiDuMapUtils {

    //百度app_key
    private static final String APP_KEY = "S02dBiGNRShsG9O2Vpg6zFMiQMBgTOuI";
    private static final String BAIDU_MAP_URL = "http://api.map.baidu.com/directionlite/v1/driving";


    /**
     *
     * @param orgLng
     * @param orgLat
     * @param desLng
     * @param desLat
     * @return
     */
    public static String getDistance(double orgLng, double orgLat, double desLng, double desLat) {
        Map<String, Object> param = new HashMap<>();
        String origin=orgLat+","+orgLng;
        String destination=desLat+","+desLng;
        param.put("origin",origin);
        param.put("destination",destination);
        param.put("ak",APP_KEY);
        String res = HttpClientUtils.sendGet(BAIDU_MAP_URL, param);
        System.out.println(res.toString());
        JSONObject jsonObject = JSONObject.fromObject(res);
        JSONObject obj=jsonObject.getJSONObject("result");
        if(obj!=null){
            Object routes = obj.getJSONArray("routes").get(0);
            JSONObject jsonObject1 = JSONObject.fromObject(routes);
            String distance = jsonObject1.getString("distance");
            System.out.println("距离1："+jsonObject1.getString("distance"));
            return distance;
        }
        return null;
    }

    public static void main(String[] args) {
        //104.070815,30.581795 孵化园      origin=30.581795,104.070815&destination=30.565733,104.065337
        //104.065337,30.565733 两江国际  origin=40.01116,116.339303&destination=39.936404,116.452562
        /*String url="http://api.map.baidu.com/directionlite/v1/driving?origin=40.01116,116.339303&destination=39.936404,116.452562&ak="+APP_KEY;
        Map<String, Object> param=null;
        System.out.println(url);
        String res = HttpClientUtils.sendGet(url, param);
        System.out.println(res.toString());
        JSONObject jsonObject = JSONObject.fromObject(res);
        JSONObject obj=jsonObject.getJSONObject("result");
        Object zx = obj.getJSONArray("routes").get(0);
        JSONObject jsonObject1 = JSONObject.fromObject(zx);
        System.out.println("距离1："+jsonObject1.getString("distance"));*/

        double orgLng=106.095636;
        double orgLat=30.808363;
        double desLng=104.06219238281;
        double desLat=30.573171283833;
        String distance = getDistance(orgLng, orgLat, desLng, desLat);
        System.out.println(distance);

    }
}
