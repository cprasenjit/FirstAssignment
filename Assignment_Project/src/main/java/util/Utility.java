package main.java.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility extends Base {

	public void screenshot() {

		try {

			TakesScreenshot srcShot = (TakesScreenshot) driver;
			File srcfile = srcShot.getScreenshotAs(OutputType.FILE);
			File destfile = new File(System.getProperty("user.dir") + "\\target\\Screenshot " + timestamp() + ".png");
			FileUtils.copyFile(srcfile, destfile);
		} catch (IOException e) {

			System.out.println("Filepath for screenshot is not set correctly.." + e.getMessage());

		}
	}
	
	public void screenshotForFailedTest(String methodname) {

		try {

			TakesScreenshot srcShot = (TakesScreenshot) driver;
			File srcfile = srcShot.getScreenshotAs(OutputType.FILE);
			File destfile = new File(System.getProperty("user.dir") + "\\target\\Screenshot "+methodname + timestamp() + ".png");
			FileUtils.copyFile(srcfile, destfile);
			
			System.out.println("working");
		} catch (IOException e) {

			System.out.println("Filepath for screenshot is not set correctly.." + e.getMessage());

		}
	}

	public String timestamp() {

		return new SimpleDateFormat("yyyy-mm-dd HH-mm-ss").format(new Date());
	}

	public void expilicitWait(WebElement ele) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElements(ele));
	}

}
