package com.yxyz.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * 功能说明:资源工具类
 */
public final class JsonMsgUtil {

	private static final Logger log = LoggerFactory.getLogger(JsonMsgUtil.class);

	private static Properties propertie = new Properties();

	private static String DEFAULT_MESSAGE = "";

	static {
		try {
			propertie = PropertiesLoaderUtils.loadProperties(new PathMatchingResourcePatternResolver().getResource("classpath:conf/json-msg.properties"));
		} catch (IOException e1) {
			String s = "Load resource file failed.";
			log.error(s);
		}
	}

	public static String getMsg(String key) {
		String message = propertie.getProperty(key, DEFAULT_MESSAGE);
		try {
			message = new String(message.getBytes("UTF-8"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return DEFAULT_MESSAGE;
		}
		return message;
	}

	public static String getMsg(int key) {
		String message = propertie.getProperty("" + key, DEFAULT_MESSAGE);
		try {
			message = new String(message.getBytes("UTF-8"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return DEFAULT_MESSAGE;
		}
		return message;
	}

}
