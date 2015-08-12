package com.dreamnight.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebIpUtil {

	private final static Logger logger = LoggerFactory.getLogger(WebIpUtil.class);

	/**
	 * 获取useragent的关键字和全部
	 * 
	 * @param request
	 * @return 例："testlib/1.0 (iPhone; iOS 8.1; Scale/2.00)" 返回
	 *         "iPhone"和"testlib/1.0 (iPhone; iOS 8.1; Scale/2.00)"
	 */
	public static String[] getUserAgentArr(HttpServletRequest request) {
		String uaStr = request.getHeader("User-Agent");
		if (StringUtils.isNotBlank(uaStr)) {
			return new String[] { uaStr.substring(uaStr.indexOf("(") + 1, uaStr.indexOf(";")), uaStr };
		}
		return null;
	}

	/**
	 * Get client ip address
	 * 
	 * @param request
	 * @return String, ip address
	 */
	public static String getIpAddress(HttpServletRequest request) {
		String ip = parseIpFromRequest(request);
		if (StringUtils.isNotBlank(ip) && StringUtils.indexOf(ip, ",") > 0) {
			String[] ipArray = StringUtils.split(ip, ",");
			for (String ipItem : ipArray) {
				if (!ipItem.equalsIgnoreCase("unknown")) {
					ip = ipArray[0];
					break;
				}
			}
		}
		if (StringUtils.isBlank(ip)) {
			ip = "127.0.0.1";
			logger.info("ipaddress is blank, set default value : " + request.getRequestURI());
		}
		return ip;
	}

	/**
	 * 取得ip串
	 * 
	 * @param request
	 * @return
	 */
	public static String getAllIpAddress(HttpServletRequest request) {
		return parseIpFromRequest(request);
	}

	/**
	 * 从request取得ip串
	 * 
	 * @param request
	 * @return
	 */
	private static String parseIpFromRequest(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (StringUtils.isBlank(ip) || StringUtils.equalsIgnoreCase(ip, "unknown")) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (StringUtils.isBlank(ip) || StringUtils.equalsIgnoreCase(ip, "unknown")) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (StringUtils.isBlank(ip) || StringUtils.equalsIgnoreCase(ip, "unknown")) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (StringUtils.isBlank(ip) || StringUtils.equalsIgnoreCase(ip, "unknown")) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (StringUtils.isBlank(ip) || StringUtils.equalsIgnoreCase(ip, "unknown")) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public static String combinePrefixAndKey(String prefix, String key) {
		return prefix + key;
	}


}
