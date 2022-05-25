package com.actitime.users;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.actitime.testbase.BaseClass;

public class CreateUser extends BaseClass{
	 @Test
	  public void testCreateUser() throws InterruptedException {
		 driver.findElement(By.id("container_users")).click();
		 driver.findElement(By.xpath("//div[text()='New User']")).click();
		 System.out.println("This is Test");
		 
		 String fn=xlib.getExcelData("CreateUser", 1, 0);
		 String ln=xlib.getExcelData("CreateUser", 1, 1);
		 String em=xlib.getExcelData("CreateUser", 1, 2);
		 driver.findElement(By.id("createUserPanel_firstNameField")).sendKeys(fn);
		 driver.findElement(By.id("createUserPanel_lastNameField")).sendKeys(ln);
		 driver.findElement(By.id("createUserPanel_emailField")).sendKeys(em);
		 driver.findElement(By.id("createUserPanel_emailField")).sendKeys(Keys.TAB);
		 System.out.println("This is Department");
		 Thread.sleep(2000);
		 //driver.findElement(By.xpath("(//div[text()='-- department not assigned --'])[1]")).click();
		 //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//div[text()='Save & Send Invitation']")).click();
		//div[contains(@class, 'components_button submitBtn')
		 System.out.println("last stept");
		 //System.out.println("This is Production");
		 //driver.findElement(By.xpath("//div[text()='&nbsp']")).click();
		 //driver.findElement(By.xpath("(//div[text()='Production'])[5]")).click();
		 
		
	  }
}
