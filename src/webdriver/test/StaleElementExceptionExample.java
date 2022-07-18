package webdriver.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementExceptionExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// application launch
		driver.get("https://www.tutorialspoint.com/about/about_careers.htm");

		// identify element
		WebElement l = driver.findElement(By.id("search-strings"));

		// enter text
		l.sendKeys("Selenium");

		// refresh page
		driver.navigate().refresh();

		// again enter text
		try {
			l.sendKeys("Selenium");
		} catch (StaleElementReferenceException ex) {
			System.out.println("StaleElement Exception occured");
			driver.navigate().refresh();
			l = driver.findElement(By.id("search-strings"));
			l.sendKeys("jmeter");
		}

		// browser quit
		driver.quit();
	}
}
/*The term stale means something which is not fresh and decayed. Thus a stale element points to an element that is not present anymore.

There may be a case when an element was in DOM initially but after modifications in Document Object Model (DOM), the element becomes stale and the StaleElementReferenceException is thrown if we attempt to access this element.

This exception is caused whenever an element is not present in the DOM or deleted. We can handle this exception in the following ways −

Refreshing the page and verifying again.
Implement the retry method.
*/