package com.rameshsoft.testanalysis;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDemo {
    @Test
	public static void test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		System.out.println("Browser launched successfully..");
		driver.manage().window().maximize();
		driver.get("https://www.jqueryui.com");
		
		WebElement ele = driver.findElement(By.xpath("//a[text()='Datepicker']"));
		ele.click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		System.out.println("Datepicker is selected...");
		
		LocalDate localDate = LocalDate.now();
		String str[] = localDate.toString().split("-");
		String date = str[2];
		int date1 =Integer.parseInt(date);
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@id=\"ui-datepicker-div\"]/div/following-sibling::table/thead/following-sibling::tbody/tr/td/a"));
		
		for(WebElement element: elements) {
			String txt = element.getText();
			int dates = Integer.parseInt(txt);
			if(date1==dates) {
			element.click();
			System.out.println("Element selected..");
			Thread.sleep(3000);
			break;
			}
		}
		
		driver.close();
	}
	
	
}
