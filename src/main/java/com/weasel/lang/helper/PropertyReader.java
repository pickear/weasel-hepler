package com.weasel.lang.helper;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * 
 * @author Dylan
 *
 */
public class PropertyReader {

	private PropertyReader(){}
	
	public static CompositeConfiguration config = new CompositeConfiguration();
	
	public PropertyReader read(String fileName){
		try {
			config.addConfiguration(new PropertiesConfiguration(fileName));
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public String getProperty(String key){
		return config.getString(key);
	}
	
	public static PropertyReader newInstance(){
		return new PropertyReader();
	}
}
