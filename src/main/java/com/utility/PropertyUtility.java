package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.config.Constants;

public class PropertyUtility {
	/**
	 * This method will open Header.Properties and return value associate with
	 * key
	 * 
	 * @param key
	 * @return value in form of{@code String}
	 */
<<<<<<< HEAD
	public static String getProperty(String key,String propertiesFilepath) {
=======
	public static String getProperty(String key) {
>>>>>>> bcad512805cb0041cd39885152254a646ae3e7cb
		String value = null;
		FileInputStream fis;
		
		try {
<<<<<<< HEAD
			fis = new FileInputStream(propertiesFilepath);
=======
			 fis = new FileInputStream("src\\main\\resources\\LivingPage.properties");
>>>>>>> bcad512805cb0041cd39885152254a646ae3e7cb
			Properties prop= new Properties();
			prop.load(fis);
					value = prop.getProperty(key);
		} catch (IOException e) {
<<<<<<< HEAD
			System.out.println("Unable to load Properties File");
			e.printStackTrace();
		}
		return value;
											}
=======
			System.out.println("Unable to load Properties File)");
			e.printStackTrace();
		}
		return value;
												}
>>>>>>> bcad512805cb0041cd39885152254a646ae3e7cb
	}