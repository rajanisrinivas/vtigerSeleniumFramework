package com.crm.productTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Createcontactwithlastname {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\admin\\OneDrive\\Desktop/commondata.properties");
		Properties p=new Properties();
		p.load(fis);

		String BROWSER = p.getProperty("Browser");
		String URL=p.getProperty("Url");
		String USERNAME=p.getProperty("UserName");
		String PASSWORD=p.getProperty("Password");
		Random ran=new Random();
		int random=ran.nextInt(1000);
		FileInputStream fiss=new FileInputStream("./testdata/Orgnztn.xlsx");
		Workbook w=WorkbookFactory.create(fiss);
		Sheet sh = w.getSheet("Sheet2");
		Row row=sh.getRow(1);
		 String lastname= row.getCell(2).toString()+ random ;
		
		 w.close();
	      WebDriver driver=null;
	      if(BROWSER.equals("edge"))
			{
				driver = new EdgeDriver();
				
			}
			else if (BROWSER.equals("firefox")) {
				driver = new FirefoxDriver();
			}
			else if (BROWSER.equals("chrome")) {
				driver = new ChromeDriver();
		}
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			driver.findElement(By.name("lastname")).sendKeys(lastname);
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			String t = driver.findElement(By.id("mouseArea_Last Name")).getText();
			System.out.println(t);
			if(t.contains(lastname)) {
				System.out.println("pass");
				
			}
			else {
				System.out.println("fail");
			}
			 driver.quit();
	}

}
