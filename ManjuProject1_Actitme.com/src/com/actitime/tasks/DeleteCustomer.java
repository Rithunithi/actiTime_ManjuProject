package com.actitime.tasks;



import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.actitime.pageclass.TasksPage;
import com.actitime.testbase.BaseClass;

public class DeleteCustomer extends BaseClass{
	 @Test
	  public void testDeleteCustomer() {
		 TasksPage tp=new TasksPage();
		 tp.clickOnTasks(driver);
		 String dc=xlib.getExcelData("DeleteCustomer", 1, 0);
		 driver.findElement(By.xpath("(//input[@placeholder='Start typing name ...'])[1]")).sendKeys(dc);
		 driver.findElement(By.xpath("//span[text()='"+dc+"']/../../..//div[@class='editButton']")).click(); 
		 driver.findElement(By.xpath("(//div[text()='ACTIONS'])[1]")).click();
		 driver.findElement(By.xpath("(//div[text()='Delete'])[2]")).click();  
		 driver.findElement(By.xpath("(//span[text()='Delete permanently'])")).click();
		 System.out.println("Finished delete customer");
	  }
}
