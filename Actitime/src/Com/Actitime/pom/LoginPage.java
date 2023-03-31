package Com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
//decleration
	
	
	@FindBy(id="username")
	private WebElement untbx;
	
	@FindBy(name="pwd")
	private WebElement pwtxb;
	
	@FindBy(xpath="//div[.='Login '")
	private WebElement Lgbtn;
	 
	//initization
	
	
	
	
	public LoginPage(WebDriver d) {
	
		PageFactory.initElements(d, this);
	}


	
	//utilization
	
	
	public WebElement getUntbx() {
		return untbx;
	}

	public WebElement getPwtxb() {
		return pwtxb;
	}

	public WebElement getLgbtn() {
		return Lgbtn;
	}
	
	
}
