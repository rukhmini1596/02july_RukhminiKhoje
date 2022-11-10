package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VarifyWatchVideoLessons {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("comments added");
		//this is my comments
		int count=0;
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium material\\chromedriver_win32\\chrome92 version\\chromedriver.exe");		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://byjus.com/byjus-classes-book-free-60-mins-class/?utm_source=google&utm_mode=CPA&utm_campaign=K10-IN-Brand-BYJU%27S-USD-Exact&utm_term=byjus&gclid=EAIaIQobChMI6fiRnfyO-wIV3ZpmAh2dpAPgEAAYASAAEgIoxfD_BwE");
	
		WebElement dropdown=driver.findElement(By.xpath("//select[@class='form-control video-selection']"));
		WebElement scroll=driver.findElement(By.xpath("//h2[text()='Watch video lessons ']"));

		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", scroll);
		Select select= new Select(dropdown);
		for(int index=0; index<7; index++) {
			Thread.sleep(2000);
			select.selectByIndex(index);
			System.out.println("Available demo videos for Class " + (index+4));
			List<WebElement> videos=driver.findElements(By.xpath("//div[@class='row row-inline']//a"));
			if(videos.size()==2) {
				System.out.println("passed");
			}
			for(int i=0; i<videos.size(); i++) {
				videos.get(i).click();
				driver.switchTo().frame(0);
				Thread.sleep(1000);
				String videoName=driver.findElement(By.xpath("//div[@class='ytp-title-text']")).getText();
				System.out.println(videoName);
				driver.switchTo().defaultContent();
				driver.findElement(By.xpath("(//button[@type='button'])[14]")).click();
				
			}
			System.out.println("==================================================");
		}
	}
}


//videos.get(1).click();
//driver.switchTo().frame(0);
//Thread.sleep(2000);
//videoName=driver.findElement(By.xpath("//div[@class='ytp-title-text']")).getText();
//System.out.println(videoName);
//driver.switchTo().defaultContent();
//driver.findElement(By.xpath("(//button[@type='button'])[14]")).click();
