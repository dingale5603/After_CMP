package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.BaseTest;

public class FacebookLogin_POM {
public WebDriver driver;
	@FindBy(id="email")
	private WebElement username;
	@FindBy(id="pass")
	private WebElement password;
	@FindBy(id="loginbutton")
	private WebElement loginbutton;
	
	public FacebookLogin_POM(WebDriver driver) {
	//	driver=this.driver;
		PageFactory.initElements(driver, this);
	
	}
	public void enter_UserName() {
		username.sendKeys("deepak");
	}
	public void enter_Password() {
		password.sendKeys("deepak");
	}
	public void click_loginbutton() {
		loginbutton.click();
	}

}
