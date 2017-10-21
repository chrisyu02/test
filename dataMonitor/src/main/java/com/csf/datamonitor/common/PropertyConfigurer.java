package com.csf.datamonitor.common;

import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.google.common.collect.Maps;

public class PropertyConfigurer extends PropertyPlaceholderConfigurer{
	private static Logger log = Logger.getLogger(PropertyConfigurer.class);
	private static Map<String, String> ctxPropertiesMap;
	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
		// TODO Auto-generated method stub
		super.processProperties(beanFactoryToProcess, props);
		ctxPropertiesMap = Maps.newHashMap();
		for(Object key : props.keySet()){
			String keyStr = key.toString();
			String value = props.getProperty(keyStr);
			log.debug("[key] : " + keyStr);
			ctxPropertiesMap.put(keyStr, value);
		}
	}
	public static String getContextProperty(String name){
		return ctxPropertiesMap.get(name);
	}
}
