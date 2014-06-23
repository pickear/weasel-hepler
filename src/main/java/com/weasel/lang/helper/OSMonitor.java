package com.weasel.lang.helper;

import java.util.Properties;

import org.apache.commons.lang.StringUtils;


/**
 * the class of system
 * through this class,we can get the info of system
 * @author Dylan
 * @time 下午8:53:41
 */
public class OSMonitor {

	/**
	 * the properties of system
	 */
	private final static Properties props = System.getProperties();
	
	/**
	 * get the name of system
	 * @return the name of system
	 */
	public static String getSystemName(){
		return props.getProperty("os.name").toLowerCase();
	}
	
	/**
	 * get the version of system
	 * @return the version of system
	 */
	public static String getSystemVersion(){
		return props.getProperty("os.version").toLowerCase();
	}
	
	/**
	 * get the separator of file,such as unix is "/"
	 * @return
	 */
	public static String getFileSeparator(){
		return props.getProperty("file.separator");
	}
	
	/**
	 * get the separator of path,such as unix is "."
	 * @return the path separator
	 */
	public static String getPathSeparator(){
		return props.getProperty("path.separator");
	}
	
	/**
	 * get the version of java,now the system is using
	 * @return the java version
	 */
	public static String getJavaVersion(){
		return props.getProperty("java.version").toLowerCase();
	}
	
	/**
	 * get the home of java
	 * @return java home
	 */
	public static String getJavaHome(){
		return props.getProperty("java.home").toLowerCase();
	}
	
	/**
	 * the system is unix or not
	 * @return
	 */
	public boolean isUnix(){
		return StringUtils.contains(getSystemName(), "unix");
	}
	
	/**
	 * the system is windows or not
	 * @return
	 */
	public boolean isWindows(){
		return StringUtils.contains(getSystemName(), "windows");
	}
	
	public boolean isLinux(){
		return StringUtils.contains(getSystemName(), "linux");
	}
	
	private OSMonitor(){}
}
