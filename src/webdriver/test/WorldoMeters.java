package webdriver.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorldoMeters {

	static String popXpath = "//div[@class='maincounter-number']/span";
	// static String todaysXpath =
	// "//div[text()='Today']/following-sibling::div/div[@class='sec-counter']";
	// static String thisYearXpath = "//div[text()='This
	// year']//following-sibling::div/div[@class='sec-counter']";
	static String todayOrthisYearXpath = "//div[text()='Today' or text()='This year']//following-sibling::div/div[@class='sec-counter']";
	private static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.worldometers.info/world-population/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		int count = 1;
		while (count <= 20) {
			System.out.println(count + " Second\n~~~~~~~~~~");
			System.out.println("Current World Population\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			printPopulation(popXpath);
			System.out.println("Count of Today and This Year\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			printPopulation(todayOrthisYearXpath);

			Thread.sleep(1000);
			count++;
		}
	}

	private static void printPopulation(String locator) throws InterruptedException {

		List<WebElement> popList = driver.findElements(By.xpath(locator));
		for (WebElement ele : popList) {
			System.out.println(ele.getText());
		}
	}

}
