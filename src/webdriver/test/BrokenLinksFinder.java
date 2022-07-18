package webdriver.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksFinder {

	private static ChromeDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		long startTime = System.currentTimeMillis();
		//sequential way to check broken link
		//links.stream().forEach(ele -> checkBrokenLink(ele.getAttribute("href")));
		
		//parallell way to check broken link, faster than above way
		links.parallelStream().forEach(ele -> checkBrokenLink(ele.getAttribute("href")));
		long endTime = System.currentTimeMillis();

		System.out.println("Total Time taken: " + (endTime - startTime));
	}

	private static void checkBrokenLink(String elementUrl) {
		try {
			URL url = new URL(elementUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.connect();
			if (conn.getResponseCode() >= 400) {
				System.out.println(elementUrl + " --->" + conn.getResponseMessage());
			} else {
				System.out.println(elementUrl + " ---> working");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
