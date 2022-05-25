package com.actitime.users;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.actitime.testbase.BaseClass;

public class DeleteUser extends BaseClass{
	 @Test
	  public void testDeleteUser() throws InterruptedException {
		 System.out.println("Before");
		 driver.findElement(By.id("container_users")).click();
		 System.out.println("After");
		 driver.findElement(By.xpath(("//th[@class='userName secondLayer']/../.. /..//div[@class='icon']"))).click();
		 String du=xlib.getExcelData("DeleteUser", 1, 0);
		 driver.findElement(By.xpath("//div[@class='inputPlaceholder animShowWordsField']/..//input[@placeholder='Start typing name...']")).sendKeys(du);
		 System.out.println("DeleteUser");
		 //driver.findElement(By.xpath("//span[text()='Ramesh']")).click();
		 driver.findElement(By.xpath("//span[@class='userNameSpan']")).click();
		 System.out.println("DeleteUser1");
		 driver.findElement(By.xpath("//div[text()='DELETE']")).click();
		 System.out.println("DeleteUser2");
		 Alert al = driver.switchTo().alert();
	     al.accept();
	     //Thread.sleep(3000);
	  }
}
