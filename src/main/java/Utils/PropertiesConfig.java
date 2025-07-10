package Utils;

import java.io.InputStream;
import java.util.Properties;

import com.google.common.cache.CacheLoader;

public class PropertiesConfig {

	 static Properties props = new Properties();
	 public  PropertiesConfig() {
		 try (InputStream input = CacheLoader.class.getClassLoader().getResourceAsStream("config.properties")) {
			 if (input == null) {
	                System.out.println("Sorry, config.properties not found");
	                return ;
	            }
	             props.load(input);
	            
	  	  } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	 }
	 public static String getProperty(String key) {
		 return props.getProperty(key);
	 }
	 
}
