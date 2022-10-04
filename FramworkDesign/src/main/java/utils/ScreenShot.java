package utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import test.BaseTest;

public class ScreenShot {
	public static void screeshot() throws IOException {
		 File source=((TakesScreenshot)BaseTest.getDriver()).getScreenshotAs(OutputType.FILE);
		    Date d=new Date();
		    String currentdate = d.toString().replace(":", "_");
		    File dest=new File(getproperty.getprop()+currentdate+"image.png");
		    try {
				FileHandler.copy(source, dest);
			} catch (IOException e) {
				
				e.printStackTrace();
				
	}
		    

}}
