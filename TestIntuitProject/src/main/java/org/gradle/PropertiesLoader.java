package org.gradle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

/**
 * 
 * @author Naga Vellanki 11/09/2016 
 */
public class PropertiesLoader {
	public final Properties configProp = new Properties();

	public  PropertiesLoader() {
		try {
			// Private constructor to restrict new instances
			InputStream in = new FileInputStream("resources/config.properties");
			configProp.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static class LazyHolder {
		private static final PropertiesLoader INSTANCE = new PropertiesLoader();
	}

	public static PropertiesLoader getInstance() {
		return LazyHolder.INSTANCE;
	}

	public String getProperty(String key) {

		return configProp.getProperty(key);
	}

	public Set<String> getAllPropertyNames() {
		return configProp.stringPropertyNames();
	}

	public boolean containsKey(String key) {
		return configProp.containsKey(key);
	}
}