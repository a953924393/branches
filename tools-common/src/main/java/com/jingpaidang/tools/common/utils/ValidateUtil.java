package com.jingpaidang.tools.common.utils;

import java.util.List;


public class ValidateUtil {
	private ValidateUtil() {
	};

	/**
	 * 判断字符串的有效性
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isValidated(String str) {
		if (str == null || "".equals(str.trim())) {
			return false;
		}
		return true;
	}

	/**
	 * 判断集合有效性 如果存在，则返回真，如果不存在返回假
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isValidated(List list) {
		if (list == null || list.isEmpty()) {
			return false;
		}
		return true;
	}

}
