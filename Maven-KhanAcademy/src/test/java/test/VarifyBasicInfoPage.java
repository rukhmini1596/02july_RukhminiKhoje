package test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VarifyBasicInfoPage {
public static void main(String[] args) throws InterruptedException {
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
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(3000);
	//span[@class='empty-field pure-hidden-xs']
	
	WebElement initialUserName=driver.findElement(By.xpath("//span[@class='_19lfck2n']"));
	//System.out.println(initialUserName.getText());
	initialUserName.click();
	Thread.sleep(2000);
	List<WebElement> basicInfoFields=driver.findElements(By.xpath("//label[@class='control-label']"));
	
	Thread.sleep(1000);
	System.out.println(basicInfoFields.get(0).getText());
	WebElement nickNameInfo=driver.findElement(By.xpath("(//p[@class='input-description'])[1]"));
	System.out.println(nickNameInfo.getText());
	System.out.println("================================================================================");
	
	System.out.println(basicInfoFields.get(1).getText());
	WebElement userNameInfo=driver.findElement(By.xpath("(//p[@class='input-description'])[2]"));
	WebElement username1=driver.findElement(By.xpath("//input[@id='username']"));
	username1.clear();
	
	Random random = new Random();
	username1.sendKeys("Rukhu"+random.nextInt());
	System.out.println(userNameInfo.getText());
	System.out.println("Message afer Entering username");
	WebElement message=driver.findElement(By.xpath("//span[@class='sidenote success']"));
	System.out.println(message.getText());
	System.out.println("=================================================================================");
		
	System.out.println(basicInfoFields.get(2).getText());
	WebElement textArea=driver.findElement(By.xpath("//div[@class='user-bio-edit-view']//textarea"));
	textArea.clear();
	textArea.sendKeys("My favorite subject is chemistry");
	WebElement charleft=driver.findElement(By.xpath("//span[@class='left chars-left']"));
	System.out.println(charleft.getText());
	
	System.out.println("================================================================================");
	
	driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Rukhmini@123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	Thread.sleep(2000);
	WebElement finalUserName=driver.findElement(By.xpath("//div[@class='user-deets editable']"));
	//System.out.println(finalUserName.getText());
//	if(!finalUserName.equals(initialUserName)) {
//		System.out.println("Passed");
//	}
//	driver.close();
	}
}
