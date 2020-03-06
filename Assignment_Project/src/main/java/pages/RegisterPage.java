package main.java.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import main.java.util.Base;

public class RegisterPage extends Base {
	
	
	@FindBy(xpath = "//label[text()='First name']")
	WebElement firstnameLabel;

	@FindBy(xpath = "//label[text()='Last name']")
	WebElement lastnameLabel;
	
	@FindBy(xpath = "//label[text()='Country']")
	WebElement countryLabel;

	@FindBy(xpath = "//label[text()='Address']")
	WebElement addressLabel;
	
	@FindBy(xpath = "//label[text()='Contact']")
	WebElement contactLabel;

	@FindBy(xpath = "//label[text()='Gender*']")
	WebElement genderLabel;
	
	@FindBy(xpath = "//label[text()='Date of birth*']")
	WebElement dateOfBirthLabel;

	@FindBy(xpath = "//label[text()='Email*']")
	WebElement emailLabel;
	
	@FindBy(xpath = "//label[text()='Username']")
	WebElement usernameLabel;

	@FindBy(xpath = "//label[text()='Password']")
	WebElement passwordLabel;
	
	@FindBy(xpath = "//label[text()='Confirm Password']")
	WebElement confirmPasswordLabel;
	
	@FindBy(xpath = "//label[text()='Subscribe to Newsletter']")
	WebElement subscribeNewsletterLabel;
	
	@FindBy(xpath = "//td[contains(text(),'I agree to terms and conditions')]")
	WebElement termsAndConditionLabel;
	
	
	@FindBy(xpath = "//input[@id='profile_first_name']")
	WebElement firstnameTextbox;

	@FindBy(xpath = "//input[@id='profile_last_name']")
	WebElement lastnameTextbox;
	
	@FindBy(xpath = "//select[@id='profile_country']")
	WebElement countryDropdown;

	@FindBy(xpath = "//input[@id='profile_address']")
	WebElement addressTextbox;
	
	@FindBy(xpath = "//input[@id='profile_contact_no']")
	WebElement contactTextbox;

	@FindBy(xpath = "//input[@id='profile_gender_M']")
	WebElement maleCheckBox;
	
	@FindBy(xpath = "//input[@id='profile_gender_F']")
	WebElement femaleCheckBox;

	@FindBy(xpath = "//input[@id='profile_dob']")
	WebElement dateOfBirthTextbox;
	
	@FindBy(xpath = "//input[@id='profile_email']")
	WebElement emailTextbox;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordTextbox;
	
	@FindBy(xpath = "//input[@id='identity[password_confirmation]']")
	WebElement confirmPasswordTextbox;
	
	
	@FindBy(xpath = "//input[@id='profile_subscribe_to_newsletter']")
	WebElement subscribeNewsletterCheckbox;
	
	@FindBy(xpath = "//input[@id='chk_agree']")
	WebElement termsAndCondotionCheckbox;

	@FindBy(xpath = "//input[@name='commit' and @value='Create Profile']")
	WebElement createProfileButton;
	
	@FindBy(xpath = "//div[contains(text(),'Incorrect word verification! please try again')]")
	WebElement registrationErrorMessage;
	
	@FindBy(xpath = "//a[contains(text(),'MAPSYNQ')]")
	WebElement homepageLink;
	
	
	//========Register Page Methods======================//
	
	
	public void clickRegisterLink() {
		
		new HomePage().homepageRegisterLink.click();
	}
	
	
	public void displayRegisterpageDefaultView() {
		
		Assert.assertTrue(firstnameLabel.isDisplayed());
		Assert.assertTrue(lastnameLabel.isDisplayed());
		Assert.assertTrue(countryLabel.isDisplayed());
		Assert.assertTrue(genderLabel.isDisplayed());
		Assert.assertTrue(dateOfBirthLabel.isDisplayed());
		Assert.assertTrue(emailLabel.isDisplayed());
		Assert.assertTrue(passwordLabel.isDisplayed());
		Assert.assertTrue(confirmPasswordLabel.isDisplayed());
		Assert.assertTrue(subscribeNewsletterLabel.isDisplayed());
		Assert.assertTrue(termsAndConditionLabel.isDisplayed());
	}
	
	public void enterUserDetails() {
		
		firstnameTextbox.sendKeys("abc");
		lastnameTextbox.sendKeys("xyz");
		new Select(countryDropdown).selectByVisibleText("Anguilla");
		addressTextbox.sendKeys("india");
		contactTextbox.sendKeys("458796");
		femaleCheckBox.click();
		dateOfBirthTextbox.sendKeys("11-02-2020");
		dateOfBirthTextbox.sendKeys(Keys.ENTER);
		emailTextbox.sendKeys("ghj@yu.com");
		passwordTextbox.sendKeys("@#65kl");
		confirmPasswordTextbox.sendKeys("AB@#65kl");
		subscribeNewsletterCheckbox.click();
		termsAndCondotionCheckbox.click();
	}
	
	public void clickCreateProfileButton() {
		
		createProfileButton.click();
	}
	
	public void checkrErrorMessage() {
		if(registrationErrorMessage.isDisplayed()) {
			
			homepageLink.click();
			//Assert.assertTrue(false);
		}
		
	}

	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
}
