package propertyutility;

import java.io.FileInputStream;
import java.util.Properties;

import baselibraryutility.Baselibrary;

public class Propertyutility extends Baselibrary {

	static String location = System.getProperty("user.dir");

	static String path = location + "\\Configuration\\Config.properties";

	public static String readdata(String key) {
		String value = "";

		try {
			FileInputStream fis = new FileInputStream(path);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);

		} catch (Exception e) {
			System.out.println("Issue in getread data+ e");
		}

		return value;
	}
}
