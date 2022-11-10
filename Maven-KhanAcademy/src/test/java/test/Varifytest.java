package test;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import utils.UtilityClass;

public class Varifytest {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium material\\chromedriver_win32\\chrome92 version\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.khanacademy.org/");
		driver.findElement(By.xpath("//a[@id='login-or-signup']")).click();
		
		WebElement username=driver.findElement(By.xpath("(//input[@class='_1azps1NaN'])[1]"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", username);
		
		username.sendKeys("khojerukhmini@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Rukhmini@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[text()='Courses'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Class 1']")).click();
		
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@role='button']")).click();
		
		driver.findElement(By.xpath("(//a[@role='button'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		Thread.sleep(3000);
		WebElement dragableElement=driver.findElement(By.xpath("(//div[@class='card-wrap perseus-interactive'])[1]"));
		WebElement DropableElement=driver.findElement(By.xpath("//div[@class='perseus-clearfix draggable-box']"));
		Actions act = new Actions(driver);
		for(int index=0; index<7; index++) {
			Thread.sleep(1000);
			act.dragAndDrop(dragableElement, DropableElement).build().perform();
		}
		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
		UtilityClass.captureScreenshot(driver, 123);
		WebElement msg=driver.findElement(By.xpath("//div[@role='alert']"));
		System.out.println(msg.getText());
		

		
	}
}
