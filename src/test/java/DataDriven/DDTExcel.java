package DataDriven;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.*;

public class DDTExcel {
	
	static WebDriver driver;
	
	@Test(dataProvider="testdata")
	
	public void DemoProject(String username, String password) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dhanraj Prabhakaran\\eclipse-workspace\\SeleniumFramework\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/V4/");
		
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		
		Thread.sleep(5000);
		
		Assert.assertEquals(driver.getTitle().matches("Guru99 Bank Manager HomePage"), "Invalid credentials");		
		System.out.println("Login Successfull");
		}

	@AfterMethod
	void ProgramTermination()
	{
		driver.quit();
		
	}
	
	@DataProvider(name="testdata")
	public Object[][] TestDataFeed()
	{
		ReadExcelFile config = new ReadExcelFile("C:\\Users\\Dhanraj Prabhakaran\\eclipse-workspace\\SeleniumFramework\\data\\LoginCredentials.xlsx");
		
		int rows = config.getRowCount(0);
		
		Object[][] credentials = new Object[rows][2];
		
		for(int i=0; i<rows; i++)
		{
			credentials[i][0] = config.getData(0,i,0);
			credentials[i][1] = config.getData(0,i,1);
		}
		return credentials;
	}
	public static void main(String[] args) {
		
	}
}

