package com.jingpaidang.tools.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 常用工具类 CommonUtil
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 5/24/13
 */
public class CommonUtil {
    public static final String WEB_APP_ROOT_KEY = "cshop.webAppRoot";// WebRoot路径KEY
    public static final String PATH_PREPARED_STATEMENT_UUID = "\\{uuid\\}";// UUID路径占位符
    public static final String PATH_PREPARED_STATEMENT_DATE = "\\{date(\\(\\w+\\))?\\}";// 日期路径占位符

    /**
     * 获取WebRoot路径
     *
     * @return WebRoot路径
     */
    public static String getWebRootPath() {
        return System.getProperty(WEB_APP_ROOT_KEY);
    }

    /**
     * 随机获取UUID字符串(无中划线)
     *
     * @return UUID字符串
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 8) + uuid.substring(9, 13) + uuid.substring(14, 18) + uuid.substring(19, 23) + uuid.substring(24);
    }

    /**
     * 获取实际路径
     *
     * @param path 路径
     */
    public static String getPreparedStatementPath(String path) {
        if (!ValidateUtil.isValidated(path)) {
            return null;
        }
        StringBuffer uuidStringBuffer = new StringBuffer();
        Matcher uuidMatcher = Pattern.compile(PATH_PREPARED_STATEMENT_UUID).matcher(path);
        while (uuidMatcher.find()) {
            uuidMatcher.appendReplacement(uuidStringBuffer, CommonUtil.getUUID());
        }
        uuidMatcher.appendTail(uuidStringBuffer);

        StringBuffer dateStringBuffer = new StringBuffer();
        Matcher dateMatcher = Pattern.compile(PATH_PREPARED_STATEMENT_DATE).matcher(uuidStringBuffer.toString());
        while (dateMatcher.find()) {
            String dateFormate = "yyyyMM";
            Matcher dateFormatMatcher = Pattern.compile("\\(\\w+\\)").matcher(dateMatcher.group());
            if (dateFormatMatcher.find()) {
                String dateFormatMatcherGroup = dateFormatMatcher.group();
                dateFormate = dateFormatMatcherGroup.substring(1, dateFormatMatcherGroup.length() - 1);
            }
            dateMatcher.appendReplacement(dateStringBuffer, new SimpleDateFormat(dateFormate).format(new Date()));
        }
        dateMatcher.appendTail(dateStringBuffer);

        return dateStringBuffer.toString();
    }

    /**
     * md5加密
     */
    public static String md5(String data) {
        StringBuffer buffer = new StringBuffer();
        byte[] b1 = data.getBytes();
        char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                'B', 'C', 'D', 'E', 'F'};
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] b2 = digest.digest(b1);
            for (byte b : b2) {
                buffer.append(c[new Integer(b >> 4 & 0x0F)]);
                buffer.append(c[new Integer(b & 0x0F)]);
            }
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static int fromLong2Int(long value) {
        return Integer.valueOf(Long.toString(value));
    }
}
