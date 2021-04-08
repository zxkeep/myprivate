package com.scxinglin.utils;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * 远程访问HttpClient get post 请求
 * @author zhengxu
 * @create 2019-04-08
 */
public class HttpClientUtils {
    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL 例如：http://localhost:8080/demo/login
     * @param param 请求参数 例：{ "userName":"admin", "password":"123456" }
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, Map<String, Object> param) {
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        try {
            URL realUrl = createURL(url, param);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Charset", "UTF-8");
            conn.connect();
            in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result.toString();
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url   发送请求的URL 例如：http://localhost:8080/demo/login
     * @param param 请求参数 例：{ "userName":"admin", "password":"123456" }
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, Map<String, Object> param) {
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            URL realUrl = createURL(url, param);
            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            // 发送POST请求必须设置
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(true);
            // 设置通用的请求属性
            conn.setRequestProperty("Charset", "UTF-8");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.connect();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result.toString();
    }


    private static URL createURL(String url, Map<String, Object> param) throws MalformedURLException {
        if (param == null || param.size() == 0) {
            return new URL(url);
        }
        StringBuilder sb = new StringBuilder(url);
        sb.append("?");
        for (String key : param.keySet()) {
            sb.append(key);
            sb.append("=");
            sb.append(encode(String.valueOf(param.get(key))));
            sb.append("&");
        }
        return new URL(sb.substring(0, sb.length() - 1));
    }

    private static String encode(String text) {
        try {
            return URLEncoder.encode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
 
 