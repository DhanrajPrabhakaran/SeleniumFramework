package HybridFramework;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Actions {
	
	public static WebDriver driver;
	
	public static void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dhanraj Prabhakaran\\eclipse-workspace\\SeleniumFramework\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public static void navigate()
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V4/");
	}
	
	public static void input_Username()
	{
		driver.findElement(By.name("uid")).sendKeys("mngr220639");
	}
	
	public static void input_Password()
	{
		driver.findElement(By.name("password")).sendKeys("ArEvAtE");		
	}
	
	public static void click_Login() throws Exception
	{
		driver.findElement(By.name("btnLogin")).click();
		Thread.sleep(5000);
	}
	
	public static void verify_Login()
	{
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle,"Guru99 Bank Manager HomePage");		
		System.out.println(pageTitle);
	}
	
	public static void closeBrowser()
	{
		driver.quit();
	}
	
	
	
}
