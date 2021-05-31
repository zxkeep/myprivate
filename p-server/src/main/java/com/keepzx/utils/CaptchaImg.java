package com.keepzx.utils;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Administrator on 2017/3/9.
 */
public class CaptchaImg {
    private int width = 220;
    private int height = 80;
    private volatile static CaptchaImg captchaImg;
    private ThreadLocal<String> code = new ThreadLocal<>();

    private CaptchaImg() {

    }

    public String getCode() {
        return code.get();
    }

    public static CaptchaImg getInstance() {
        if (captchaImg == null) {
            synchronized (CaptchaImg.class) {
                if (captchaImg == null) {
                    captchaImg = new CaptchaImg();
                }
            }
        }
        return captchaImg;
    }

    private BufferedImage createCaptcha() {

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        //  生成随机类
        Random random = new Random();
        //  设定背景色
        g.setColor(new Color(250, 250, 250));
        g.fillRect(0, 0, width, height);
        //  设定字体
        g.setFont(new Font("Times New Roman", Font.PLAIN, 72));

        //  随机产生32条干扰线，使图象中的认证码不易被其它程序探测到
        g.setColor(new Color(54, 180, 128));
        BasicStroke stokeLine = new BasicStroke(8.0f);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(stokeLine);

        for (int i = 0; i < 1; i++) {
            int x = random.nextInt(40);
            int y = 16 + random.nextInt(48);
            int xl = 180 + random.nextInt(40);
            int yl = 16 + random.nextInt(48);
            g2d.drawLine(x, y, xl, yl);
        }

        String litters[] = {
                "a", "B", "2", "C", "D", "4", "e", "F", "G", "6", "H", "i", "j", "K", "5", "L", "M", "7", "n",
                "P", "8", "Q", "R", "s", "T", "9", "U", "v", "W", "X", "Y", "x", "3"};
        String sRand = "";
        for (int i = 0; i < 4; i++) {
            String rand = litters[random.nextInt(litters.length)];
            sRand += rand;
            // 将认证码显示到图象中
            g.drawString(rand, (width / 5) * i + 8, height - 8);
        }
        code.set(sRand);
        return image;
    }


    public Map createCaptchaApp() {
        Integer width = 135;
        Integer height = 34;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        //  生成随机类
        Random random = new Random();
        //  设定背景色
        g.setColor(new Color(250, 250, 250));
        g.fillRect(0, 0, width, height);
        //  设定字体
        g.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        //  随机产生32条干扰线，使图象中的认证码不易被其它程序探测到
        g.setColor(new Color(54, 180, 128));
        BasicStroke stokeLine = new BasicStroke(2.0f);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(stokeLine);

        for (int i = 0; i < 1; i++) {
            int x = random.nextInt(20);
            int y = 5 + random.nextInt(28);
            int xl = 100 + random.nextInt(20);
            int yl = 5 + random.nextInt(28);
            g2d.drawLine(x, y, xl, yl);
        }

//        String litters[] = {
//                "a", "B", "2", "C", "D", "4", "e", "F", "G", "6", "H", "i", "j", "K", "5", "L", "M", "7", "n",
//                "P", "8", "Q", "R", "s", "T", "9", "U", "v", "W", "X", "Y", "x", "3"};
        String litters[] = {
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        String sRand = "";
        for (int i = 0; i < 4; i++) {
            String rand = litters[random.nextInt(litters.length)];
            sRand += rand;
            // 将认证码显示到图象中
            g.drawString(rand, (width / 5) * i + 8, height - 8);
        }
        code.set(sRand);
        Map map = new HashMap<>();
        map.put("code", sRand);
        map.put("img",image);
        return map;
    }

    public void responseWebImg(HttpServletResponse resp, HttpServletRequest request) throws IOException {
        // 禁止图像缓存。
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        resp.setContentType("image/jpeg");
        BufferedImage image = createCaptcha();
        request.getSession().setAttribute("captchaCode", code.get());
        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos = resp.getOutputStream();
        ImageIO.write(image, "jpeg", sos);
        sos.close();
    }

    public void responseAppImg(HttpServletResponse resp, HttpServletRequest request) throws IOException {

        // 禁止图像缓存。
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        resp.setContentType("image/jpeg");
        BufferedImage image = createCaptcha();
        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos = resp.getOutputStream();
        ImageIO.write(image, "jpeg", sos);
        sos.close();
    }
}
