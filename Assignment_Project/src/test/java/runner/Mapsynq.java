package test.java.runner;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import main.java.pages.HomePage;
import main.java.pages.LoginPage;
import main.java.pages.RegisterPage;
import main.java.util.Base;
import main.java.util.Utility;

public class Mapsynq extends Base {

	@Test(priority = 1)
	public void loadBrowser() {

		new Base().initialization();
		new Utility().screenshot();

	}

	@Test(priority = 2, enabled=true)
	public void testHomepageFunctionality() throws Exception {

		Reporter.log("This test verifies Homepage");

		// ======creating Homepage Object=====//

		HomePage homepageobj = new HomePage();

		homepageobj.clickSlider();
		new Utility().screenshot();

		homepageobj.displayHomepageDefaultView();
		new Utility().screenshot();

		homepageobj.clicklLegendLink();
		new Utility().screenshot();
		
		homepageobj.clicklCalenderLink();
		new Utility().screenshot();

		homepageobj.verifySearchFunctionality();
		new Utility().screenshot();

		homepageobj.verifyDirectionTabFunctionality();
		new Utility().screenshot();

		homepageobj.checkClearRouteFunctionality();
		new Utility().screenshot();

		homepageobj.verifyPersonalTabFunctioality();
		new Utility().screenshot();

		homepageobj.clickSignINButton();
		new Utility().screenshot();

		homepageobj.clickRegisterButton();
		new Utility().screenshot();

	}

	@Test(priority = 3,enabled=false)
	public void testRegisterFunctionality() {

		Reporter.log("This test verifies Registerpage");

		// ======creating Homepage Object=====//
		
		RegisterPage registerpageobj = new RegisterPage();
		
		registerpageobj.clickRegisterLink();
		new Utility().screenshot();
		
		registerpageobj.displayRegisterpageDefaultView();
		new Utility().screenshot();
		
		registerpageobj.enterUserDetails();
		new Utility().screenshot();
		
		registerpageobj.clickCreateProfileButton();
		new Utility().screenshot();
		
		registerpageobj.checkrErrorMessage();
		new Utility().screenshot();
		
	}

	@Test(priority = 4, enabled=false)
	public void testLoginFunctionality() {
		
		Reporter.log("This test verifies LoginPage");

		// ======creating login Page Object=====//
		
		LoginPage loginpageobj = new LoginPage();
		
		loginpageobj.clickLoginLink();
		new Utility().screenshot();
		
		loginpageobj.displayLoginPageDefaultView();
		new Utility().screenshot();
		
		loginpageobj.enterUserCredentials();
		new Utility().screenshot();
	}
	
	@AfterMethod
	public void screenshotForFailedTests(ITestResult result) {
		if(ITestResult.FAILURE==result.getStatus()) {
			String methodname = result.getName();
			new Utility().screenshotForFailedTest(methodname);
		}
	}
	

	@AfterTest
	public void teardownBrowser() {
		new Base().closeBrowser();
	}

}
