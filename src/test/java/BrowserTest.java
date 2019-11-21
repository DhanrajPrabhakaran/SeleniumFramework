import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Dhanraj Prabhakaran\\eclipse-workspace\\SeleniumFramework\\drivers\\geckodriver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://facebook.com/");
		Thread.sleep(3000);
		driver.close();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dhanraj Prabhakaran\\eclipse-workspace\\SeleniumFramework\\drivers\\chromedriver\\chromedriver.exe");
		WebDriver cdriver=new ChromeDriver();
		cdriver.get("http://google.com/");
		Thread.sleep(3000);
		cdriver.close();
		
		System.setProperty("webdriver.ie.driver", "C:\\Users\\Dhanraj Prabhakaran\\eclipse-workspace\\SeleniumFramework\\drivers\\IEdriver\\IEDriverServer.exe");
		WebDriver idriver=new InternetExplorerDriver();
		idriver.manage().window().maximize();
		idriver.get("http://google.com/");
		Thread.sleep(3000);
		idriver.close();
		
	}

}
