package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {

	private final static String propertyFilePath= "configs/config.properties";
	
	public static String readProperty(String property) {
		Properties prop;
		String value = null;
		try {
			prop = new Properties();
			prop.load(new FileInputStream(new File(propertyFilePath)));
			value = prop.getProperty(property);					
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return value;
	}
}

