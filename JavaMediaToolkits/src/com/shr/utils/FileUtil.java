package com.shr.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {
	
	/**
	 * 删除文件或者文件夹
	 * @param url 文件路径
	 */
	public static void delFile(String url){
		File file = new File(url);
		file.delete();
	}
	
	/**
	 * 非递归文件列表
	 * @param root 文件夹路径
	 * @return 返回文件夹中的所有文件
	 */
	public static File[] listFile(String root){
		File file = new File(root);
		if(file.isDirectory()){
			return file.listFiles();
		}else{
			return new File[0];
		}
	}
	
	/**
	 * 读取文本内容
	 * @param url 文本路径
	 * @return 文本内容
	 */
	public static String readTxt(String url){
		File file = new File(url);
		StringBuilder content = new StringBuilder("");
		BufferedReader reader = null;  
        try {
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            while ((tempString = reader.readLine()) != null) {  
            	content.append(tempString);
            }
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                	e1.printStackTrace();
                }  
            }
        }
        
        return content.toString();
	}
	
	/**
	 * 生成目录
	 * @param dir 目录字符串
	 */
	public static void genDir(String dir){
		File file = new File(dir);
		file.mkdirs();
	}
}
