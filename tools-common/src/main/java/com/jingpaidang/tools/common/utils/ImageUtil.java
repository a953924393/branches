package com.jingpaidang.tools.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created with IntelliJ IDEA.
 * User: jackchen
 * Date: 6/25/13
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class ImageUtil {
    private ImageUtil() {}

    public static byte[] downloadImage(String imgAddress) {
        try {
            URL url = new URL(imgAddress);
            URLConnection conn = url.openConnection();
            InputStream inputStream = conn.getInputStream();

            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            int rc = 0;
            while ((rc = inputStream.read(buff, 0, 1024)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            byte[] in2b = swapStream.toByteArray();
            return in2b;

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return null;
    }

}
