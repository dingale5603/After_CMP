package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class getproperty {
	static Properties prop;
	public static String getprop() throws IOException  {
	 prop=new Properties();
	//String projectpath = System.getProperty("C:/Users/admin/eclipse-workspace");
    InputStream inputprop;
	
		inputprop = new FileInputStream("C:/Users/admin/eclipse-workspace/FramworkDesign/src/main/java/utils/Config.properties");
	
     prop.load(inputprop);
    String Screenshotpath = prop.getProperty("Screenshotpath");
   return Screenshotpath;
   //System.out.println(Screenshotpath);
	
}
	
}
