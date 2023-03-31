package Com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
 public static WebDriver d;
 File_Library f=new File_Library();
 
	@BeforeSuite
	public void databaseconnection()
	{
		Reporter.log("database is connected succesfuly");
	}
@AfterSuite
public void databasedisconnection()
{
	Reporter.log("database is disconnected succesfuly");
}
@BeforeClass
public void launchbrowser() throws IOException
{
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--remote-allow-origins=*");
	 d= new ChromeDriver(option);
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	String URL = f.readDataFromProperty("url");
	d.get(URL);
	Reporter.log("browser launched",true);
	
}
@AfterClass
public void closebrowser()
{
	d.close();
	Reporter.log("browser close",true);
	}
@BeforeMethod
public void login() throws IOException
{ 
	String un = f.readDataFromProperty("username");
	d.findElement(By.id("username")).sendKeys(un);
	String ps = f.readDataFromProperty("password");
	d.findElement(By.name("pwd")).sendKeys(ps);
	d.findElement(By.xpath("//div[.='Login ']")).click();
	Reporter.log("log in",true);
}
@AfterMethod
public void logout()
{
	d.findElement(By.linkText("Logout")).click();
	Reporter.log("log out",true);
	}
}















