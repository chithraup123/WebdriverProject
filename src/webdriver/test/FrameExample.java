package webdriver.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameExample {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//switch to a frame which has frame id as "frame2"
		driver.switchTo().frame("frame2");
		//driver.switchTo().frame(0);
		WebElement frame2Element = driver.findElement(By.xpath("//h1[@id=\"sampleHeading\"]"));
		System.out.println(frame2Element.getText());
		
		//to switch back to previous window
		driver.switchTo().parentFrame();

	}

}
