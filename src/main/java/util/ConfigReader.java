package util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

public class ConfigReader {

	public static Properties initializeProperties() {
		
		Properties prop=new Properties();
		//wrote code of property file here
		String path=System.getProperty("user.dir")+"//src//test//resources//ContextFile//context.properties";
		File f=new File(path);
		try {
		FileInputStream fis=new FileInputStream(f);
		prop.load(fis);
		}catch(Throwable e) {
			
		}
		return prop;
	}
	
	public static String mailidwithtimestamp() {
		Date d=new Date();
		String timestampdate=d.toString().replace(" ","_").replace(":","_");
		return "pramesh"+timestampdate+"@gmail.com";
	}
}
