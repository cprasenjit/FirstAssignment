package main.java.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static WebDriver driver;
	public static Properties prop;

	public Base() {

		prop = new Properties();

		try {

			FileReader reader = new FileReader("src\\main\\java\\config\\config.properties");
			prop.load(reader);
			reader.close();

		} catch (FileNotFoundException e) {

			System.out.println("Properties file is not available.." + e.getMessage());

		} catch (IOException e) {

			System.out.println("Unable to load the properties file..." + e.getMessage());
		}
		

	}

	public void initialization() {

		String url = prop.getProperty("testurl");
		String browsername = prop.getProperty("browsername");

		switch (browsername) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + prop.getProperty("chromedriverpath"));
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + prop.getProperty("firefoxdriverpath"));
			driver = new ChromeDriver();
			break;
			
		default:
			System.out.println("Please provide the browsername properly...");

		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
	}

	public void closeBrowser() {
		driver.close();
	}
}
