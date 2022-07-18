package webdriver.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsExample {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement button1 = driver.findElement(By.xpath("//button[@id=\"alertButton\"]"));
		button1.click();
		
		Alert alert1 = driver.switchTo().alert();
		System.out.println("Alert Text: "+alert1.getText());
		alert1.accept();
		//alert1.dismiss();
		driver.switchTo().defaultContent();
		WebElement button2 = driver.findElement(By.xpath("//button[@id=\"promtButton\"]"));
		button2.click();
		Alert alert2 = driver.switchTo().alert();
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		alert2.sendKeys("Chithra");
		alert2.accept();
		//alert2.
		
		

	}

}
