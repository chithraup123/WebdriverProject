package webdriver.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDropExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// li[@id="credit2"]/a - bank
		// li[@id="fourth"]/a -5000

		// to of bank-->//ol[@id="bank"]/li
		// to of amt ---> //ol[@id="amt7"]/li
		
		WebElement fromElementBank = driver.findElement(By.xpath("//li[@id='credit2']/a"));
		
		WebElement ToBank = driver.findElement(By.xpath("//ol[@id='bank']/li"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(fromElementBank, ToBank).build().perform();
		
		WebElement moneyFromElement = driver.findElement(By.xpath("//li[@id='credit']//following-sibling::li"));
		WebElement moneyToElement = driver.findElement(By.xpath("//ol[@id='amt7']/li"));
		action.dragAndDrop(moneyFromElement, moneyToElement).build().perform();
	}

}
