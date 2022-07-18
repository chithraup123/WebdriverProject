package webdriver.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutoItExample {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement photoElement = driver.findElement(By.xpath("//input[@id=\"uploadPicture\"]"));
		js.executeScript("arguments[0].scrollIntoView();", photoElement);
		
		Actions builder = new Actions(driver);

		builder.moveToElement(photoElement).click().build().perform();
//		//photoElement.click();

		Runtime.getRuntime().exec("D:\\Test\\autoItScript.exe");

		Thread.sleep(5000);

		//driver.close();

	}

}
