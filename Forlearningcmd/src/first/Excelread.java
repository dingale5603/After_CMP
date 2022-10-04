package first;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Excelread {
	//@Test
//	public static String Excel(int row,int col) throws EncryptedDocumentException, IOException {
//	File file=new File("C:\\Users\\admin\\Documents\\Book1.xlsx");
//    Sheet value = WorkbookFactory.create(file).getSheet("Sheet1");
//	String val = value.getRow(row).getCell(col).getStringCellValue();
//	
//	System.out.println(val);
//	return val;
//	}
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  WebElement email = driver.findElement(By.xpath("//input[@id=\"email\"]"));
//email.sendKeys("Deepak.ingale@gmail.com");
//Thread.sleep(5000);
//System.out.println(email.getAttribute("value"));
	FileInputStream fis=new FileInputStream("C:\\Users\\admin\\Desktop\\oop.xlsx");
	Workbook file = WorkbookFactory.create(fis);
	String value = file.getSheet("sheet1").getRow(0).getCell(0).getStringCellValue();
	email.sendKeys(value);
	file.getSheet("sheet1").getRow(1).createCell(1).setCellValue("ingale_ 8379");
	FileOutputStream fos=new FileOutputStream("C:\\Users\\admin\\Desktop\\oop.xlsx");
	file.write(fos);
	
	}
	}


