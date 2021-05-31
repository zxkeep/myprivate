package com.keepzx.utils;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;


public class InterceptorReturn {
    private static final Logger LOG = LoggerFactory.getLogger(InterceptorReturn.class);
    public static final Charset UTF8 = Charset.forName("utf-8");

    public static <T extends Serializable> void returnError(HttpServletResponse response, T t) {
        if(t == null) {
            return;
        }
        String strJson = JSON.toJSONString(t);
        byte[] data = strJson.getBytes(UTF8);
        response.setCharacterEncoding(UTF8.name());
        response.setContentType(String.format("application/json; charset=%s", UTF8.name()));
        response.setContentLength(data.length);
        try (OutputStream out = response.getOutputStream()) {
            out.write(data, 0, data.length);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
