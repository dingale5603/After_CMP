package testclass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.FacebookLogin_POM;
import test.BaseTest;


public class Facebooklogin_Test extends BaseTest {
	 private static WebDriver driver;
		
     @BeforeClass
 	public void setUp() {
 		driver=getDriver();
 	} 
     
     @Test
	public void login_user()
	{
        FacebookLogin_POM is =new FacebookLogin_POM(driver);
		
		is.enter_UserName();
		is.enter_Password();
		is.click_loginbutton();
	}
}

