package webdriver.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookSignUp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Create New Account')]"));
		signUpLink.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement signUpText = driver.findElement(By.xpath("//div[contains(text(),'Sign Up')]"));
		wait.until(ExpectedConditions.visibilityOf(signUpText));

		WebElement firstName = driver.findElement(By.cssSelector("input[name=firstname]"));
		WebElement lastName = driver.findElement(By.cssSelector("input[name=lastname]"));
		WebElement mobNumber = driver.findElement(By.cssSelector("input[aria-label^='Mobile number']"));
		WebElement pwd = driver.findElement(By.cssSelector("input[data-type='password']"));

		firstName.sendKeys("Abcd");
		lastName.sendKeys("Xyz");
		mobNumber.sendKeys("919879768463");
		pwd.sendKeys("Abc123456");
		
		String strGender = "Custom";
		
	    //label[text()='Female']/following-sibling::input
		WebElement genderElement = driver.findElement(By.xpath("//label[text()='"+strGender+"']/following-sibling::input"));
		genderElement.click();
		
		//take the array of values from drop down and print it on console
		List<WebElement> months = driver.findElements(By.xpath("//select[@id='month']/option"));
		
		for (WebElement month : months) {
			System.out.println(month.getText());
		}
		
		//to check the current month
		//select[@id='month']/option[@selected=1]
		
		WebElement monthSelected = driver.findElement(By.xpath("//select[@id='month']/option[@selected=1]"));
		//using css selector, used greater than symbol for child --->	select#month>option[selected='1']
		System.out.println("Current month: ");
		System.out.print(monthSelected.getText());
		
		
		//Use Select for dropdown
		
		WebElement dayDropDown = driver.findElement(By.cssSelector("select#day"));
		WebElement monthDropDown = driver.findElement(By.cssSelector("select#month"));
		WebElement yearDropDown = driver.findElement(By.cssSelector("select#year"));
		
		Select daySelect = new Select(dayDropDown);
		daySelect.selectByVisibleText("10");
		
		Select monthSelect = new Select(monthDropDown);
		monthSelect.selectByVisibleText("Aug");
		
		Select yearSelect = new Select(yearDropDown);
		yearSelect.selectByVisibleText("2000");
	}

}
