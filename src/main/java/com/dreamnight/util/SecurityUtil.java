package com.dreamnight.util;

import java.security.MessageDigest;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SecurityUtil {

	private final static Logger logger = LoggerFactory.getLogger(SecurityUtil.class);

	/**
	 * 唯一识别码
	 * @return
	 */
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		StringBuilder sb = new StringBuilder();
		sb.append(uuid.substring(0, 8));
		sb.append(uuid.substring(9, 13));
		sb.append(uuid.substring(14, 18));
		sb.append(uuid.substring(19, 23));
		sb.append(uuid.substring(24));
		return sb.toString();
	}

	/**
	 * MD5加密
	 * @param source
	 * @return
	 */
	public static String md5(String source) {
		StringBuilder sb = new StringBuilder();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(source.getBytes("UTF-8"));
			byte bytes[] = md.digest();
			String tempStr = "";
			for (int i = 0; i < bytes.length; i++) {
				tempStr = (Integer.toHexString(bytes[i] & 0xff));
	            if (tempStr.length() == 1) {
	            	sb.append("0").append(tempStr);
	            } else {
	            	sb.append(tempStr);
	            }
			}
		} catch (Exception e) {
			logger.error("md5 Exceptoion", e);
		}
		return sb.toString();
	}
	
	/**
	 * 安全哈希签名
	 * @param source
	 * @return
	 */
	public static String sha1(String source){
		StringBuilder sb = new StringBuilder();
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
			byte[] bytes = messageDigest.digest(source.getBytes("UTF-8"));
			String tempStr = "";
			for (int i = 0; i < bytes.length; i++) {
				tempStr = (Integer.toHexString(bytes[i] & 0xff));
	            if (tempStr.length() == 1) {
	            	sb.append("0").append(tempStr);
	            } else {
	            	sb.append(tempStr);
	            }
			}
		} catch (Exception e) {
			logger.error("sha1 Exceptoion", e);
		}
		return sb.toString();
	}

	/**
	 * base64编码
	 * @param inStr
	 * @return
	 */
	public static String base64Encode(String inStr) {
		Base64 base64 = new Base64(false);
		try {
			return (new String(base64.encode(inStr.getBytes("UTF-8")), "UTF-8")).replaceAll("\\r\\n", "");
		} catch (Exception e) {
			logger.error("Base64Encode "+inStr+" exception", e);
			return inStr;
		}
	}

	/**
	 * base64解码
	 * @param inStr
	 * @return
	 */
	public static String base64Decode(String inStr) {
		Base64 base64 = new Base64(false);
		try {
			return new String(base64.decode(inStr.getBytes("UTF-8")), "UTF-8");
		} catch (Exception e) {
			logger.error("Base64Decode "+inStr+" exception", e);
			return inStr;
		}
	}

}
