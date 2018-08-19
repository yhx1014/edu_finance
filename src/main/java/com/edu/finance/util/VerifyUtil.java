package com.edu.finance.util;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;


public class VerifyUtil {

	/**
	 * 校验IP地址
	 *
	 * @param hostName
	 * @return
	 */
	public static boolean verifyIPHostName(String hostName) {
		if (StringUtils.isEmpty(hostName)) {
			return false;
		}
		String reg = "^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)($|(?!\\.$)\\.)){4}$";
		Pattern p = Pattern.compile(reg);
		Matcher matcher = p.matcher(hostName);
		boolean matches = matcher.matches();
		return matches;
	}

	/**
	 * 校验IP端口号
	 *
	 * @param port
	 * @return
	 */
	public static boolean verifyIPPort(String port) {
		if (StringUtils.isEmpty(port)) {
			return false;
		}
		String reg = "^([1-9]\\d{0,3}|[1-5]\\d{4}|6[0-5]{2}[0-3][0-5])(-([1-9]\\d{0,3}|[1-5]\\d{4}|6[0-5]{2}[0-3][0-5]))?$";
		Pattern p = Pattern.compile(reg);
		Matcher matcher = p.matcher(port);
		boolean matches = matcher.matches();
		return matches;
	}

	/**
	 * 校验手机号
	 *
	 * @param mobilePhone
	 */
	public static boolean verifyMobilePhone(String mobilePhone) {
		if (StringUtils.isEmpty(mobilePhone)) {
			return false;
		}
		String reg = "^1[3578]\\d{9}$";
		Pattern p = Pattern.compile(reg);
		Matcher matcher = p.matcher(mobilePhone);
		boolean matches = matcher.matches();
		return matches;
	}

	/**
	 * 校验固定电话
	 *
	 * @param telephone
	 */
	public static boolean verifyTelephone(String telephone) {

		if (StringUtils.isEmpty(telephone)) {
			return false;
		}
		String reg = "^0\\d{2,3}-\\d{5,9}$";
		Pattern p = Pattern.compile(reg);
		Matcher matcher = p.matcher(telephone);
		boolean matches = matcher.matches();
		return matches;

	}

	/**
	 * 校验Email地址
	 *
	 * @param emailAddress
	 * @return
	 */
	public static boolean verifyEmaill(String emailAddress) {
		if (StringUtils.isEmpty(emailAddress)) {
			return false;
		}
		String reg = "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$";
		Pattern p = Pattern.compile(reg);
		Matcher matcher = p.matcher(emailAddress);
		boolean matches = matcher.matches();
		return matches;
	}

	/**
	 * 校验字符串是否超过最大长度 minLength = 1
	 *
	 * @param value
	 * @param maxLength
	 * @return
	 */
	public static boolean verifyLength(String value, int maxLength) {
		if (StringUtils.isEmpty(value)) {
			return false;
		}
		int minLength = 1;
		return verifyLength(value, minLength, maxLength);

	}

	public static boolean verifyLength(String value,int minLength, int maxLength) {
		minLength = minLength < 0 ? 0 : minLength;
		if (StringUtils.isEmpty(value)) {
			return minLength == 0;
		}
		int length = value.length();
		return length >= minLength && length <= maxLength;
	}

	/**
	 * 通过后缀判断文件是否是excel文件
	 *
	 * @param fileName
	 * @return
	 */
	public static boolean verifyFileTypeOfExcel(String fileName) {
		if (StringUtils.isEmpty(fileName)) {
			return false;
		}
		String reg = "\\.xlsx?$";
		Pattern p = Pattern.compile(reg);
		Matcher matcher = p.matcher(fileName);
		boolean find = matcher.find();
		return find;

	}
}

