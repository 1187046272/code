package com.shr.utils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author shr
 * 字符串处理工具类
 */
public class StringUtil {
	
	/**
	 * 获取文件后缀
	 * @param url 文件路径或者名字
	 * @return 文件后缀
	 */
	public static String getSurfix(String url){
		int index = url.lastIndexOf('.');
		if(index >= 0){
			return url.substring(index);
		}else{
			return "";
		}
	}
	
	/**
	 * 字符串转double
	 * @param str double字符串
	 * @return double数值
	 */
	public static double toDouble(String str){
		return Double.parseDouble(str);
	}
	
	public static boolean isRMVB(String str){
		if("rmvb".endsWith(str) || "rm".endsWith(str)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 根据文件路径返回文件名
	 * @param url 文件路径
	 * @return 文件名
	 */
	public static String getFileName(String url){
		File file = new File(url);
		if(file.exists()){
			return file.getName();
		}else{
			return url.substring(url.lastIndexOf('/'));
		}
	}
	
	/**
	 * 生成UUID
	 * @return 返回UUID
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString();
	}
	
	
	/**
	 * 字符串转日期
	 * @param timeStr 时间字符串
	 * @param pattern 时间格式
	 * @return 日期
	 */
	public static Date toDateTime(String timeStr,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(timeStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
