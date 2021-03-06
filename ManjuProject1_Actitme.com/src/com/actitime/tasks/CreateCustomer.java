 package com.actitime.tasks;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.actitime.pageclass.TasksPage;
import com.actitime.testbase.BaseClass;

public class CreateCustomer extends BaseClass{
  @Test
  public void testCreateCustomer() {
	  TasksPage tp=new TasksPage();
	  tp.clickOnTasks(driver );
	  tp.clickOnAddNew(driver);
	  //driver.findElement(By.xpath("//div[text()='Add New']")).click();
	  driver.findElement(By.xpath("//div[text()='+ New Customer']")).click();
	  String cn=xlib.getExcelData("CreateCustomer", 1, 0);
	  String cd=xlib.getExcelData("CreateCustomer", 1, 1);
	  driver.findElement(By.xpath("(//input[@placeholder='Enter Customer Name'])[2]")).sendKeys(cn);
	  driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']")).sendKeys(cd);
	  driver.findElement(By.xpath("//div[text()='Create Customer']")).click(); 
	 // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  System.out.println("Finished create customer");
	  //driver.findElement(By.id("logoutLink")).click();
	  //System.out.println("Finished CR logoutLink");
  }
  
}
