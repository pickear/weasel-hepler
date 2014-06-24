package com.weasel.helper;

import com.weasel.core.logging.JdkLogger;

/**
 * @author Dylan
 * @mail pickear@gmail.com
 * @time 2014年7月17日
 */
public final class JdkLoggerFactory {
	

	private JdkLoggerFactory(){}
	
	/**
	 * @param clazz
	 * @return
	 */
	public static JdkLogger getLogger(Class<?> clazz){
		return new JdkLogger(clazz.getName());
	}
	
	/**
	 * @param clazz
	 * @return
	 */
	public static JdkLogger getLogger(String clazz){
		return new JdkLogger(clazz);
	}
}
