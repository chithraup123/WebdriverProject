package webdriver.test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement windowButton = driver.findElement(By.xpath("//button[@id='windowButton']"));
		System.out.println("Before clicking");
		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent Handle: " + parentHandle);
		windowButton.click();

		// getWindowHandles gets all the window handles a set as it should not give a
		// duplicate value
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String currVal = null;
		while (it.hasNext()) {
			currVal = it.next();
			if (!currVal.equals(parentHandle)) {
				driver.switchTo().window(currVal);
			}
		}

		WebElement childWindowElement = driver.findElement(By.xpath("//h1[@id=\"sampleHeading\"]"));
		System.out.println(childWindowElement.getText());
		
	}

}
