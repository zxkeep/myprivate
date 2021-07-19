package com.keepzx.pcms.controller;

import com.keepzx.pcms.common.BaseResultVO;
import com.keepzx.utils.DownLoadUtils;
import com.keepzx.utils.UrlFilesToZip;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author keep-zx
 * @version 1.0.0
 * @create 2021-07-19 16:19
 * @desc 下载controller
 */
@RestController
@Slf4j
public class DownLoadController {


    @RequestMapping(value = "/file/down/load/zip", method = RequestMethod.POST)
    public void filesDown(HttpServletResponse response){
        try {
            //String filename = new String("xx.zip".getBytes("UTF-8"), "ISO8859-1");//控制文件名编码
            String fileName = URLEncoder.encode("mykeep.zip","UTF-8");
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ZipOutputStream zos = new ZipOutputStream(bos);
            UrlFilesToZip s = new UrlFilesToZip();
            int idx = 1;
            List<String> urls = new ArrayList<>();
            urls.add("https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIxK6gcaxSLbBYgnmqviaFbgYAzQl5mV7lAN3fibCYPpZUMNJUFZ99o6r1XY4zsNIhs0M5r0yBvBMMQ/132");
            urls.add("https://thirdwx.qlogo.cn/mmopen/vi_32/ChrD2tibYYhVfeicoHPo2LMFEJ22UgtF1T6AD8QSYkPFzQNjGy55xJPS1dYs0omkUv2toTz2ytywoYpSVdoOu2eQ/132");
            urls.add("https://thirdwx.qlogo.cn/mmopen/vi_32/jzolSZeeE8I2Fo8nlJw2ia2k54tq4GyiaOicmANfrvrmk5SjRCicic4J4LAGmSeH0qwIQibCNDKicNbIIqAEE4eP8C5yw/132");
            for (String oneFile : urls) {
                zos.putNextEntry(new ZipEntry("profile" + idx +".jpg"));
                byte[] bytes = s.getImageFromURL(oneFile);
                zos.write(bytes, 0, bytes.length);
                zos.closeEntry();
                idx++;
            }
            zos.close();
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
            OutputStream os = response.getOutputStream();
            os.write(bos.toByteArray());
            os.close();
        } catch (FileNotFoundException ex) {
            log.error("FileNotFoundException", ex);
        } catch (Exception ex) {
            log.error("Exception", ex);
        }
    }

    @RequestMapping(value = "/file/down/load/zip1", method = RequestMethod.POST)
    public BaseResultVO filesDownZip(HttpServletResponse response){
        Map<String, String> map = new HashMap<>();
        map.put("1001","https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIxK6gcaxSLbBYgnmqviaFbgYAzQl5mV7lAN3fibCYPpZUMNJUFZ99o6r1XY4zsNIhs0M5r0yBvBMMQ/132");
        map.put("1002","https://thirdwx.qlogo.cn/mmopen/vi_32/ChrD2tibYYhVfeicoHPo2LMFEJ22UgtF1T6AD8QSYkPFzQNjGy55xJPS1dYs0omkUv2toTz2ytywoYpSVdoOu2eQ/132");
        map.put("1003","https://thirdwx.qlogo.cn/mmopen/vi_32/jzolSZeeE8I2Fo8nlJw2ia2k54tq4GyiaOicmANfrvrmk5SjRCicic4J4LAGmSeH0qwIQibCNDKicNbIIqAEE4eP8C5yw/132");
        DownLoadUtils.urlFilesDownToZip(response,map,"keep.zip");
        return new BaseResultVO();
    }
}