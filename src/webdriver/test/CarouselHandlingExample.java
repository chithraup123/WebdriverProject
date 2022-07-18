package webdriver.test;

import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarouselHandlingExample {

	static String carouselStr1 = "Health care essentials";
	static String recommendedXpath = "//*[text()='Recommended for you']/parent::div/following-sibling::div//div[@class='swiper-wrapper']";
	private static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.noon.com/uae-en/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		System.out.println(carouselStr1 + "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		String carouselHeadingXpath = "//div/h3[text()='" + carouselStr1 + "']";
		By carouselHeadingLocator = By.xpath(carouselHeadingXpath);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		while (true) {
			try {
				if (driver.findElement(carouselHeadingLocator) != null) {
					break;
				}
			} catch (NoSuchElementException ex) {
				js.executeScript("window.scrollTo(0, 1500);");
				driver.navigate().refresh();
				Thread.sleep(1000);
			}

		}
		printCaruselItems(carouselStr1);
	}

	private static void printCaruselItems(String carouselName) throws InterruptedException {

		TreeSet<String> itemTitleSet = new TreeSet<>();
		String carouselNextButtonXPath = "//*[text()='" + carouselName + "']/parent::div/following-sibling::div/div[2]";
		String carouselItemNameXpath = "//*[text()='" + carouselName
				+ "']/parent::div/following-sibling::div//div[@data-qa='product-name']";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1000)", "");

		List<WebElement> carouselItems = driver.findElements(By.xpath(carouselItemNameXpath));
		System.out.println(carouselItems.size());
		addCarouselItemsToSet(carouselItems, itemTitleSet);

		Thread.sleep(1000);
		while (driver.findElement(By.xpath(carouselNextButtonXPath)).isDisplayed()) {

			driver.findElement(By.xpath(carouselNextButtonXPath)).click();
			System.out.println("The next button is on enabled status now\n*****************************");
			carouselItems = driver.findElements(By.xpath(carouselItemNameXpath));
			addCarouselItemsToSet(carouselItems, itemTitleSet);
		}

		itemTitleSet.forEach(item -> System.out.println("The item title is " + item));
	}

	private static void addCarouselItemsToSet(List<WebElement> carouselItems, TreeSet<String> itemTitleSet) {
		carouselItems.stream().forEach(item -> {
			if (item.isDisplayed()) {

				String itemTitle = item.getAttribute("title");
				System.out.println(itemTitle + "has displayed");
				itemTitleSet.add(itemTitle);
			}
		});
	}

}
