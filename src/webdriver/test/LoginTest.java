package webdriver.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

	public static void main(String[] args) {

		// System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

		// WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement loginElement = driver.findElement(By.linkText("Log in"));
		wait.until(ExpectedConditions.elementToBeClickable(loginElement));
		loginElement.click();

		WebElement userName = driver.findElement(By.name("user_login"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement button = driver.findElement(By.name("btn_login"));
		WebElement rememebrMe = driver.findElement(By.className("rememberMe"));

		userName.sendKeys("xyz@abc.com");
		password.sendKeys("Abc12345");
		rememebrMe.click();
		button.click();
		String errorMsg = driver.findElement(By.id("msg_box")).getText();
		System.out.println(errorMsg);
		// driver.close();

		List<WebElement> links = driver.findElements(By.tagName("a"));
//		for(WebElement link:links) {
//			System.out.println(link.getAttribute("href"));
//		}
		links.forEach(link -> System.out.println(link.getAttribute("href")));
		int totalLinks = links.size();
		System.out.println("Total links are: " + totalLinks);

	}

}
