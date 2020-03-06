package main.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import main.java.util.Base;

public class LoginPage extends Base {

	@FindBy(xpath = "//b[text()='	Sign In ']")
	WebElement signInText;

	@FindBy(xpath = "//td[contains(text(),'Email')]")
	WebElement email_usernameLabel;

	@FindBy(xpath = "//input[@id='name']")
	WebElement email_usernameTextbox;

	@FindBy(xpath = "//td[contains(text(),'Password')]")
	WebElement passwordLabel;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordTextbox;

	@FindBy(xpath = "//a[contains(text(),'or Create Account')]")
	WebElement createAccountLink;

	@FindBy(xpath = "//a[text()='Forgot password/account?']")
	WebElement forgotPasswordLink;

	@FindBy(xpath = "//input[@name='commit']")
	WebElement signInButton;
	
	@FindBy(xpath = "//a[contains(text(),'MAPSYNQ')]")
	WebElement homepageLink;

	// ========Login Page Methods==============//
	
	public void clickLoginLink() {
		
		new HomePage().homepageSignInLink.click();
	}

	public void displayLoginPageDefaultView() {

		Assert.assertTrue(signInText.isDisplayed());
		Assert.assertTrue(email_usernameLabel.isDisplayed());
		Assert.assertTrue(email_usernameTextbox.isDisplayed());
		Assert.assertTrue(passwordLabel.isDisplayed());
		Assert.assertTrue(passwordTextbox.isDisplayed());
		Assert.assertTrue(createAccountLink.isDisplayed());
		Assert.assertTrue(forgotPasswordLink.isDisplayed());
		Assert.assertTrue(signInButton.isDisplayed());

	}
	
	public void enterUserCredentials() {
		
		email_usernameTextbox.sendKeys("ghj@yu.com");
		passwordTextbox.sendKeys("test");
		
		signInButton.click();
		
		homepageLink.click();
	}
	

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
}
