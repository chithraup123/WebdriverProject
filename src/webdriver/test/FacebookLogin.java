package webdriver.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement userName = driver.findElement(By.xpath("//*[@id='email']"));
		WebElement password = driver.findElement(By.xpath("//*[@id='pass']"));
		WebElement button = driver.findElement(By.xpath("//*[@name='login']"));
		
		userName.sendKeys("abc@xyz@gmail.com");
		password.sendKeys("Abcghh123");
		button.click();
		
		WebElement newAccountBtn = driver.findElement(By.xpath("//*[text()='Create New Account']"));
		
		
	}

}
