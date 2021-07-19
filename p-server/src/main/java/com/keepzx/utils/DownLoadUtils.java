package com.keepzx.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author keep-zx
 * @version 1.0.0
 * @create 2021-07-19 17:06
 * @desc 下载工具
 */
public class DownLoadUtils {

    private static final Logger logger = LoggerFactory.getLogger(DownLoadUtils.class);

    public static void urlFilesDownToZip(HttpServletResponse response, Map<String,String> urls, String zipName){
        try {
            String zipNameEncode = URLEncoder.encode(zipName,"UTF-8");
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ZipOutputStream zos = new ZipOutputStream(bos);
            UrlFilesToZip s = new UrlFilesToZip();
//            List<String> urls = new ArrayList<>();
//            urls.add("https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIxK6gcaxSLbBYgnmqviaFbgYAzQl5mV7lAN3fibCYPpZUMNJUFZ99o6r1XY4zsNIhs0M5r0yBvBMMQ/132");
//            urls.add("https://thirdwx.qlogo.cn/mmopen/vi_32/ChrD2tibYYhVfeicoHPo2LMFEJ22UgtF1T6AD8QSYkPFzQNjGy55xJPS1dYs0omkUv2toTz2ytywoYpSVdoOu2eQ/132");
//            urls.add("https://thirdwx.qlogo.cn/mmopen/vi_32/jzolSZeeE8I2Fo8nlJw2ia2k54tq4GyiaOicmANfrvrmk5SjRCicic4J4LAGmSeH0qwIQibCNDKicNbIIqAEE4eP8C5yw/132");
            for (Map.Entry<String, String> entry : urls.entrySet()) {
                String oneFile = entry.getValue();
                String entryFileName = entry.getKey();
                zos.putNextEntry(new ZipEntry(entryFileName +".jpg"));
                byte[] bytes = s.getImageFromURL(oneFile);
                zos.write(bytes, 0, bytes.length);
                zos.closeEntry();
            }
            zos.close();
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + zipNameEncode);// 设置文件名
            OutputStream os = response.getOutputStream();
            os.write(bos.toByteArray());
            os.close();
        } catch (FileNotFoundException ex) {
            logger.error("FileNotFoundException", ex);
        } catch (Exception ex) {
            logger.error("Exception", ex);
        }
    }


}