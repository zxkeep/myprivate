package com.scxinglin.utils;

import net.sf.json.JSONObject;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.List;

public class JsonUtils {
    private final static ObjectMapper mapper = new ObjectMapper();

    public static String beanToString(Object o) throws IOException {
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return mapper.writeValueAsString(o);
    }

    public static <T> T json2bean(String json,Class<T> clazz) throws IOException {
        T o = mapper.readValue(json, clazz);
        return o;
    }

    public static <T> String listConvert2Json(List<T> objects, Class clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
        ObjectWriter typedWriter = mapper.writerWithType(mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        return typedWriter.writeValueAsString(objects);
    }

    public static String objectConvert2Json(Object object, Class clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
        return mapper.writeValueAsString(object);
    }

    public static <T> T jsonConvert2List(String str, TypeReference<T> trf)throws IOException{
        return mapper.readValue(str,trf);
    }

    private static JavaType getJavaType(Type type, Class<?> clazz) {
        return (clazz != null) ?
                TypeFactory.type(type, TypeFactory.type(clazz)) : TypeFactory.type(type);
    }

    public static Object readFromStream(InputStream inputStream, Class<?> clazz)throws IOException {
        JavaType javaType = getJavaType(clazz, null);
        return mapper.readValue(inputStream, javaType);
    }

    public static void responseJson(HttpServletResponse response, Object object) {
        JSONObject responseJSONObject = JSONObject.fromObject(object);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try (PrintWriter out = response.getWriter()) {
            out.append(responseJSONObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
