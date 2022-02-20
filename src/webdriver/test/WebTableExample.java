package webdriver.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//		List<WebElement> tableCustomersRows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
//		System.out.println("No of rows: "+tableCustomersRows.size());
//		
//		List<WebElement> tableCustomersCols = driver.findElements(By.xpath("//table[@id='customers']//th"));
//		System.out.println("No of columns: "+tableCustomersCols.size());
//		
//		List<WebElement> rowValues = driver.findElements(By.xpath("//table[@id = 'customers']//tr[2]/td"));
//		rowValues.forEach(rowValue->System.out.println(rowValue.getText()));

		// passing column number and find the values
		int column = 1;
		List<WebElement> names = driver.findElements(By.xpath("//table[@id = 'customers']//td[" + column + "]"));
		names.forEach(name -> System.out.println(name.getText()));

		// Find the country of a contact

		// table[@id="customers"]//td[text()="Helen Bennett"]/following-sibling::td

		String contactPerson = "Helen Bennett";
		WebElement countryElement = driver.findElement(
				By.xpath("//table[@id=\"customers\"]//td[text()=\"" + contactPerson + "\"]/following-sibling::td"));
		System.out.println("The country of " + contactPerson + "is " + countryElement.getText());	

	}

}
