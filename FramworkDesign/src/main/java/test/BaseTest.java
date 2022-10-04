package test;

import java.lang.reflect.Method;
import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;




public class BaseTest {
	private static WebDriver driver;
    private ExtentHtmlReporter htmlReporter;
    private ExtentReports reporter;
    private ExtentTest logger;
	
	public static WebDriver getDriver() {
		
		return driver;
	
	}
	
	
	@BeforeTest
	public void extent() {
		htmlReporter=new ExtentHtmlReporter("C:\\Users\\admin\\eclipse-workspace\\FramworkDesign\\Reports.html") ;
		
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Automation Test report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		reporter=new ExtentReports();
		reporter.attachReporter(htmlReporter);
		reporter.setSystemInfo("Automation Tester", "Deepak Ingale");
		
		
	}
	
	@Parameters({"browserName","appUrl"})
	@BeforeMethod
	public void driverpass(@Optional String browserName, String appUrl,Method testMethod) {
		logger=reporter.createTest(testMethod.getName());
		setDriver(browserName);
		driver.get(appUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	
	@AfterMethod
	public void C(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			String methodname = result.getMethod().getMethodName();
			String logtext = "Test case"+methodname+"Passed";
			Markup m = MarkupHelper.createLabel(logtext, ExtentColor.GREEN);
			logger.log(Status.PASS, m);
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			String methodname = result.getMethod().getMethodName();
			String logtext = "Test case"+methodname+"Failed";
			Markup m = MarkupHelper.createLabel(logtext, ExtentColor.RED);
			logger.log(Status.FAIL, m);
		}
		
		driver.quit();
		
	}
	
	
	@AfterTest
	public void D() {
		reporter.flush();
	}

private void setDriver(String browserName) {
	if(browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();	
	}
	else if(browserName.equalsIgnoreCase("FireFox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();	
	}else {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();	
	}
}


}
