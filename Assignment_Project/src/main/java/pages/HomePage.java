package main.java.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import main.java.util.Base;

public class HomePage extends Base {

	// ========Homepage Locators=========//

	@FindBy(xpath = "//div[@id='ad_toggle' and @class='sprite ad_bar_toggle ad_bar_collapse']")
	WebElement homepageSlider;

	@FindBy(xpath = "//a[@class='header_logo sprite']")
	WebElement homepageLogo;

	@FindBy(xpath = "//input[@id='txtGlobalSearch']")
	WebElement homepageSearchBox;

	@FindBy(xpath = "//span[@class='search_icon sprite']")
	WebElement homepageSearchIcon;

	@FindBy(xpath = "//a[@class='tab_button directions_tab sprite']")
	WebElement homepageDirectionTab;

	@FindBy(xpath = "//a[@class='tab_button me_tab sprite']")
	WebElement homepagePersonalTab;

	@FindBy(xpath = "//a[@class='tab_button live_tab sprite tab_active']")
	WebElement homepageLiveTab;

	@FindBy(xpath = "//a[text()='Sign in']")
	WebElement homepageSignInLink;

	@FindBy(xpath = "//a[text()='Register ']")
	WebElement homepageRegisterLink;

	@FindBy(xpath = "//a[text()='Mobile App']")
	WebElement homepageMobileAppLink;

	@FindBy(xpath = "//a[text()='Galactio']")
	WebElement homepageGalactioLink;

	@FindBy(xpath = "//a[text()='SG GPS Navigation']")
	WebElement homepageGpsNavigationLink;

	@FindBy(xpath = "//a[text()='Legend']")
	WebElement homepageLegendLink;

	@FindBy(xpath = "(//div[@class='ui-dialog-titlebar ui-widget-header ui-helper-clearfix ui-corner-tr ui-corner-tl'])[2]")
	WebElement homepageLegendTray;

	@FindBy(xpath = "//a[text()='Calendar']")
	WebElement homepageCalenderLink;

	@FindBy(xpath = "(//span[@class='ui-dialog-title'])[3]")
	WebElement homepageCalenderTray;

	@FindBy(xpath = "//input[@value='Sign in' and @class='sprite float_right margin_right_15 press-it-btn press-it-btn-base']")
	WebElement SignInButton;

	@FindBy(xpath = "//input[@value='Register' and @class='sprite float_left margin_left_165 press-it-btn-big press-it-btn-base']")
	WebElement RegisterButton;

	@FindBy(xpath = "(//span[@class='sprite calendar_synq_icon'])[1]")
	WebElement calenderSyncIcon;

	@FindBy(xpath = "(//span[@class='sprite notification_icon'])")
	WebElement notificationIcon;

	@FindBy(xpath = "//span[@class='sprite favourite_icon']")
	WebElement favoriteIcon;

	@FindBy(xpath = "//input[@id='poi_from']")
	WebElement directionFromLocation;

	@FindBy(xpath = "//input[@id='poi_to']")
	WebElement directionToLocation;

	@FindBy(xpath = "//input[@id='also_traffic']")
	WebElement directionTrafficCheckbox;

	@FindBy(xpath = "//input[@id='also_fastest']")
	WebElement directionFastestCheckbox;

	@FindBy(xpath = "//input[@class='sprites press-it-btn press-it-btn-base']")
	WebElement directionGetDirectionButton;

	@FindBy(xpath = "//a[text()='Clear Route']")
	WebElement directionClearRouteLink;

	// ============Homepage methods=============//

	public void displayHomepageDefaultView() {

		Assert.assertTrue(homepageLogo.isDisplayed());
		Assert.assertTrue(homepageSearchIcon.isDisplayed());
		Assert.assertTrue(homepageSearchBox.isDisplayed());
		Assert.assertTrue(homepageDirectionTab.isDisplayed());
		Assert.assertTrue(homepagePersonalTab.isDisplayed());
		Assert.assertTrue(homepageSignInLink.isDisplayed());
		Assert.assertTrue(homepageRegisterLink.isDisplayed());
		Assert.assertTrue(homepageMobileAppLink.isDisplayed());
		Assert.assertTrue(homepageGalactioLink.isDisplayed());
		Assert.assertTrue(homepageGpsNavigationLink.isDisplayed());
		Assert.assertTrue(homepageLegendLink.isDisplayed());
		Assert.assertTrue(homepageCalenderLink.isDisplayed());

	}

	public void clickSlider() {
		homepageSlider.click();
	}

	public void clicklLegendLink() {
		homepageLegendLink.click();
		Assert.assertTrue(homepageLegendTray.isDisplayed());
	}

	public void clicklCalenderLink() {
		homepageCalenderLink.click();
		Assert.assertTrue(homepageCalenderTray.isDisplayed());
	}

	public void verifySearchFunctionality() {
		homepageSearchIcon.click();
		driver.switchTo().alert().accept();
		homepageSearchBox.sendKeys("NOVENA");
		homepageSearchIcon.click();

	}

	public void verifyDirectionTabFunctionality() throws Exception {

		homepageDirectionTab.click();
		directionFromLocation.clear();
		directionFromLocation.sendKeys("GEYLANG");
		directionToLocation.sendKeys("MARINE PARADE");
		directionGetDirectionButton.click();

		Thread.sleep(3000);
		driver.switchTo().alert().accept();

		directionTrafficCheckbox.click();
		directionFastestCheckbox.click();

	}

	public void checkClearRouteFunctionality() {

		directionClearRouteLink.click();
		Assert.assertEquals(directionFromLocation.getAttribute("value"), "");
		Assert.assertEquals(directionToLocation.getAttribute("value"), "");
	}

	public void verifyPersonalTabFunctioality() {

		homepagePersonalTab.click();
		Assert.assertTrue(SignInButton.isDisplayed());
		Assert.assertTrue(calenderSyncIcon.isDisplayed());
		Assert.assertTrue(notificationIcon.isDisplayed());
		Assert.assertTrue(favoriteIcon.isDisplayed());
		Assert.assertTrue(RegisterButton.isDisplayed());

	}

	public void clickSignINButton() {

		SignInButton.click();
		Assert.assertEquals("http://account.mapsynq.com/login?redirect_url=http%3A%2F%2Fwww.mapsynq.com%3A80%2Foauth%2Fauth_return", driver.getCurrentUrl());
		driver.navigate().back();
	}

	public void clickRegisterButton() {

		homepagePersonalTab.click();
		RegisterButton.click();
		Assert.assertEquals("http://account.mapsynq.com/profiles/new", driver.getCurrentUrl());
		driver.navigate().back();
	}

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	

}
