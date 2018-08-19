package com.edu.finance.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 读取类路径下的文件工具类
 *
 */
public class ClassPathFileUtil {

	/**
	 * 获得输入流
	 * @param name
	 * @return
	 * @throws FileNotFoundException
	 */
	public static InputStream getInputStream(String name) throws FileNotFoundException {
		URL url = ClassPathFileUtil.class.getResource(name);
		
		String exceptionMsg = "未发现指定文件：" + name;
		if (url == null) throw new FileNotFoundException(exceptionMsg);
		
		try {
			return new FileInputStream(url.getPath());   
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(exceptionMsg);
		}
	}
	
	/**
	 * 读文本文件
	 */
	public static String readTextFile(String name) throws FileNotFoundException, IOException {
		URL url = ClassPathFileUtil.class.getResource(name);
		
		String exceptionMsg = "未发现指定文件：" + name;
		if (url == null) throw new FileNotFoundException(exceptionMsg);
		
		StringBuffer json = new StringBuffer();
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(url.getPath()), "utf-8"));   
			
			String line;
			while ((line = br.readLine()) != null) {
				json.append(line);
			}
			
			String jsonStr = json.toString().replace("\r", "");
			jsonStr = jsonStr.replace("\n", "");
			jsonStr = jsonStr.replace("\t", "");
			
			return jsonStr;
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(exceptionMsg);
		} finally {
			if (br != null) {
				br.close();
			}
		}
	}
}
