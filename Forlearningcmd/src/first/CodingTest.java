package first;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CodingTest {
static WebDriver driver;
String Expected_ReleaseDate="17 December 2021";
String Expected_ReleaseCountry="India";

@BeforeMethod
public  void OpenBrowser() {
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
@Test
public void releasedate() {
	String Actual_release_Date = driver.findElement(By.xpath("//*[@id='mw-content-text']//table[1]//tr[12]//td")).getText();
	System.out.println(Actual_release_Date);
	Assert.assertEquals(Actual_release_Date, Expected_ReleaseDate);
	System.out.println("Release Date "+ Actual_release_Date);
	
	//System.out.println("Assertion is passed and Release_Date is Verified which is equal to "+Actual_release_Date);
}

@Test
public void relesecountry() {
	String Actual_release_Country = driver.findElement(By.xpath("//*[@id='mw-content-text']//table[1]//tr[14]//td")).getText();
	System.out.println(Actual_release_Country);
	Assert.assertEquals(Actual_release_Country, Expected_ReleaseCountry);

	System.out.println("Assertion is passed and Release_Country is Verified");
}
@AfterMethod
public void Quit() {
	driver.quit();
}

}


