package webdriver.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/upload/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement inputFileElement = driver.findElement(By.xpath("//input[@id=\"uploadfile_0\"]"));
		inputFileElement.sendKeys("H://SLearn//myFile.txt");
		driver.findElement(By.xpath("//button[@id=\"submitbutton\"]")).submit();

	}

}
