package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FreeOnlineCourses {
	@FindBy (xpath = "//a[@id='login-or-signup']")
	private WebElement login;
	
	public FreeOnlineCourses(WebDriver driver){
	PageFactory.initElements(driver, this);	
	}
	public void clickOnLogin(){
		login.click();
	}
}
