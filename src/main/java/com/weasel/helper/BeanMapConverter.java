/**
 * BeanMapConverter.java
 */
package com.weasel.helper;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.lang.StringUtils;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.weasel.core.annotation.FieldAlias;
import com.weasel.core.exception.TransformException;
import com.weasel.core.helper.GodHands;

/**
 * map类型与javaBean之间的转换
 * 
 * @author Dylan
 * @time 2013-3-16
 */
public class BeanMapConverter {

	/**
	 * map类型转换成javaBean
	 * 
	 * @param properties
	 *            保存bean属性和值的map
	 * @param beanClass
	 *            转换成bean的大型
	 * @return
	 */
	public static <T> T mapToBean(Map<String, Object> properties, Class<T> beanClass) {
		T bean = null;
		try {
			bean = beanClass.newInstance();
			BeanUtils.populate(bean, properties);
		} catch (InstantiationException e) {
			throw new TransformException(e.getMessage());
		} catch (IllegalAccessException e) {
			throw new TransformException(e.getMessage());
		} catch (InvocationTargetException e) {
			throw new TransformException(e.getMessage());
		}
		return bean;
	}
	

	/**
	 * javaBean 转换成 map类型
	 * 
	 * @param bean
	 *            实体bean
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Object> beanToMap(Object bean) {
		try {
			return BeanUtils.describe(bean);
		} catch (Exception e) {
			throw new TransformException(e.getMessage());
		}

	}
	
	/**
	 * 
	 * @param source
	 * @param target
	 * @param fieldMapping
	 * @return
	 */
	public static <T> T beanToBean(Object source,Class<T> target,final Map<String,String> fieldMapping){
		
		Map<String,Object> sourceMap = beanToMap(source);
		
		Map<String,Object> filtedMap = Maps.filterKeys(sourceMap, new Predicate<String>() {
			@Override
			public boolean apply(String key) {
				return fieldMapping.containsKey(key);
			}
		});
		
		for(String fieldName : fieldMapping.keySet()){
			if(sourceMap.containsKey(fieldName)){
				filtedMap.put(fieldMapping.get(fieldName), sourceMap.get(fieldName));
			}
		}
		
		return mapToBean(filtedMap, target);
	}

	public static Map<String, Object> notNullFieldMap(Object bean) {
		Map<String, Object> beanMap = Maps.newHashMap();
		try {
			PropertyDescriptor[] descriptors = getPropertyDescriptors(bean);
			for (int i = 0; i < descriptors.length; i++) {
				String name = descriptors[i].getName();
				Object value = null;
				if (!StringUtils.equals("class", name) && (getPropertyUtilsBean().getReadMethod(descriptors[i])) != null 
						&& (value = getPropertyUtilsBean().getProperty(bean, name)) != null) {
					beanMap.put(name, value);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return beanMap;
	}

	public static Map<String, Object> withAliasMap(Object bean) {
		Map<String, Object> beanMap = Maps.newHashMap();
		try {
			PropertyDescriptor[] descriptors = getPropertyDescriptors(bean);
			for (int i = 0; i < descriptors.length; i++) {
				String name = descriptors[i].getName();
				Object value = null;
				if (!StringUtils.equals("class", name) && getPropertyUtilsBean().getReadMethod(descriptors[i]) != null 
						&& (value = getPropertyUtilsBean().getProperty(bean, name)) != null) {
					FieldAlias fieldAlias = null;
					Field field =  GodHands.getAccessibleField(bean, name);
					if (null != field && null != (fieldAlias = field.getAnnotation(FieldAlias.class))) {
						name = fieldAlias.value();
					}
					beanMap.put(name, value);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return beanMap;
	}

	private static PropertyDescriptor[] getPropertyDescriptors(Object bean) {
		PropertyUtilsBean propertyUtilsBean = getPropertyUtilsBean();
		return propertyUtilsBean.getPropertyDescriptors(bean);
	}

	private static PropertyUtilsBean getPropertyUtilsBean() {
		return new PropertyUtilsBean();
	}

}
