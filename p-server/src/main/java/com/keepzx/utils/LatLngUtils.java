package com.keepzx.utils;

import static java.lang.Math.*;

public class LatLngUtils {

    //地球半径
    private static final double EARTH_RADIUS = 6378137;
    private static final double RAD = PI / 180.0;


    /**
     * 生成时间： 2016/11/7 11:59
     * 方法说明：根据提供的两个经纬度计算距离(米)
     * 开发人员：nsj
     *
     * @param lng1 第一个经度
     * @param lat1 第一个纬度
     * @param lng2 第二个经度
     * @param lat2 第二个纬度
     * @return 两个经纬度之间的距离
     */
    public static double getDistance(double lng1, double lat1, double lng2, double lat2) {
        double radLat1 = lat1 * RAD;
        double radLat2 = lat2 * RAD;
        double a = radLat1 - radLat2;
        double b = (lng1 - lng2) * RAD;
        double s = 2 * asin(sqrt(pow(sin(a / 2), 2) + cos(radLat1) * cos(radLat2) * pow(sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = round(s * 10000) / 10000;
        return s;
    }
    /**
     * 生成时间： 2016/11/7 11:57
     * 方法说明：根据提供的经度和纬度、以及半径，取得此半径内的最大最小经纬度
     * 开发人员：chenlin
     *
     * @param lon    经度
     * @param lat    纬度
     * @param raidus 半径(米)
     * @return 最大最小经纬度
     */
    public static double[] getAroundScope(double lon, double lat, int raidus) {

        Double latitude = lat;
        Double longitude = lon;

        Double degree = (24901 * 1609) / 360.0;

        Double dpmLat = 1 / degree;
        Double radiusLat = dpmLat * raidus;
        Double minLat = latitude - radiusLat;
        Double maxLat = latitude + radiusLat;

        Double mpdLng = degree * cos(latitude * (PI / 180));
        Double dpmLng = 1 / mpdLng;
        Double radiusLng = dpmLng * raidus;
        Double minLng = longitude - radiusLng;
        Double maxLng = longitude + radiusLng;

        return new double[]{minLng, maxLng, minLat, maxLat};
    }
}
