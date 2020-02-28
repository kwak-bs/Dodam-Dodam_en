package com.o2o.action.server.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class CommonUtil {
	public static final int INTEGER_AS_NULL = -100;

	public static Map<String, String> getHttpHeadersMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();

		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}
		return map;
	}

	public static String makeSafeString(Object obj) {
		if (obj != null && obj instanceof String) {
			String ret = (String) obj;
			if (ret.equalsIgnoreCase("null")) {
				ret = "";
			}
			return ret;
		} else if (obj != null && obj instanceof Integer) {
			return ((Integer) obj).toString();
		}

		return "";
	}

	public static int makeSafeInt(Object obj) {
		String str = makeSafeString(obj);
		if (str != null) {
			try {
				return Integer.parseInt(str);
			} catch (Exception e) {
			}
		}

		return INTEGER_AS_NULL;
	}

	public static boolean isEmptyString(String str) {
		if (str == null || str.length() <= 0 || str.equalsIgnoreCase("null")) {
			return true;
		}

		return false;
	}

	public static boolean isEmptyString(Object obj) {
		String str = makeSafeString(obj);

		return isEmptyString(str);
	}
	
	public static void printMapData(Map<String, Object> maps) {
		if (maps != null) {
			for (String key : maps.keySet()) {
				System.out.println(key + " : [" + maps.get(key) + "]");
			}
		}
	}
}
