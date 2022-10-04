package first;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nseweb {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nseindia.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor jse=(JavascriptExecutor) driver;
	//	jse.executeScript("window.scrollBy(0,400)");
		 WebElement name = driver.findElement(By.xpath("//*[@id='tab1Ganier']/tbody/tr[1]"));
	jse.executeScript("arguments[0].scrollIntoView()", name);
	String name1 = name.getText();
	
		System.out.println(name1);
	
	
	
	
	
	
	Thread.sleep(5000);
	driver.quit();
	}

}
