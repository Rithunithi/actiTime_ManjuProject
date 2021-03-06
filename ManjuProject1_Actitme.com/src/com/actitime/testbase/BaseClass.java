package com.actitime.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.actitime.pageclass.TasksPage;

public class BaseClass {
	public WebDriver driver;
	public ExcelLibrary xlib;
	public TasksPage tp;
  @BeforeClass
  public void openbrowser() {
	  xlib=new ExcelLibrary();
	  String browserName=xlib.getExcelData("Browser", 1, 0);
	  if (browserName.equals("Firefox")) {
		  driver=new FirefoxDriver();	
	}else if (browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "../exeFiles/chromedriver.exe");
		driver=new ChromeDriver();
	}else if (browserName.equals("ie")) {
		System.setProperty("webdriver.ie.driver", "../exeFiles/IEDriverServer.exe");
		driver=new InternetExplorerDriver();
	}
	  driver=new FirefoxDriver();
	  tp=new TasksPage();
	  driver.manage().window().maximize();
	  driver.get("https://demo.actitime.com");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  String expectedTitle="actiTIME - Login";
	  String actualTitle=driver.getTitle();
	  Assert.assertEquals(actualTitle, expectedTitle);
  }
  
  @BeforeMethod
  public void login() {
	  System.out.println("before login");
	  String un=xlib.getExcelData("Login", 1, 0);
	  String pw=xlib.getExcelData("Login", 1, 1);
	  driver.findElement(By.id("username")).sendKeys(un);
	  driver.findElement(By.name("pwd")).sendKeys(pw);
	  driver.findElement(By.id("loginButton")).click();
	  String expectedText="Enter Time-Track";
	  String actualText=driver.findElement(By.xpath("(//td[@class='pagetitle'])[1]")).getText();
	  Assert.assertEquals(actualText, expectedText);
			  		  
  }
  
  @AfterMethod
  public void logout() throws InterruptedException {
	  System.out.println("before logout");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.id("logoutLink")).click();
	  System.out.println("after logout");
  }
  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
	  Thread.sleep(3000);
	  System.out.println("before closebrowser");
	  driver.close();
	  System.out.println("after closebrowser");
  }
}
