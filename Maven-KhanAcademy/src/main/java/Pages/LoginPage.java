package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy (xpath = "(//input[@class='_1azps1NaN'])[1]")
	private WebElement username;
	
	@FindBy (xpath = "(//input[@class='_1azps1NaN'])[2]")
	private WebElement password;
	
	public LoginPage(WebDriver driver){
	PageFactory.initElements(driver, this);	
	}
	
	public void enterUsername(){
		username.sendKeys("khojerukhmini@gmail.com");
	}
	
	public void enterPassword(){
		username.sendKeys("Rukhmini@123");
	}
}
