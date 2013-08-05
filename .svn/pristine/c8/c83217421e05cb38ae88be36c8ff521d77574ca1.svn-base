package com.jingpaidang.tools.common.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StringUtil {
	private StringUtil() {};
	/**
	 * 按规则(tag)拆分字符串为数组
	 * @param str
	 * @return
	 */
	public static String[] str2Arr(String str, String tag) {
		if(ValidateUtil.isValidated(str)) {
			return str.split(tag);
		}
		return null;
	}
	/**
	 * 将输入流转换为字符串
	 * @param tInputStream
	 * @return {  "access_token": "e237ef3f-37c0-4f8e-a84b-3b83a428b5c5",  "code": 0,  "expires_in": 31103999,  "refresh_token": "dff06ac7-c3f3-408d-8e1c-3906eca7feb7",  "scope": "null",  "time": "1364809991652",  "token_type": "bearer"}
	 */
	public static String inputStream2String(InputStream tInputStream) {
		if (tInputStream != null) {
			try {
				BufferedReader tBufferedReader = new BufferedReader(
						new InputStreamReader(tInputStream));
				StringBuffer tStringBuffer = new StringBuffer();
				String sTempOneLine = new String("");
				while ((sTempOneLine = tBufferedReader.readLine()) != null) {
					tStringBuffer.append(sTempOneLine);
				}
				return tStringBuffer.toString();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
}
