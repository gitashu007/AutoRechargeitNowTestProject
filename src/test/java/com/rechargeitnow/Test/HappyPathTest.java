package com.rechargeitnow.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rechargeitnow.pages.TestCore;
import com.rechargeitnow.projectPages.HomePage;
import com.rechargeitnow.projectPages.LoginPage;

public class HappyPathTest extends TestCore{
	
	@Test(priority=0)
	public void testLogin(){
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.clickTermsCheckbox();
		loginPage.clickProceedButton();
		loginPage.clickRechargeItNowUserButton();
		loginPage.typeEmail("ashu.globalappservice@gmail.com");
		loginPage.closeKeyboard();
		loginPage.typePassword("testing123");
		loginPage.closeKeyboard();
		loginPage.scrollScreen();
		loginPage.clickLoginProceedButton();
		Assert.assertTrue(loginPage.isMobileTabPresent(), "verification of Loggedin screen is failed");
	}
	
	@Test(priority=1)
	public void testMobileRecharge(){
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		
		homePage.typeMobileNumber("9717071345");
		loginPage.scrollScreen();
		homePage.clickProceedButton();
		homePage.typeRechargeAmount("250");
		loginPage.closeKeyboard();
		homePage.clickAmountProceedButton();
		homePage.selectPaymentMethod();
		homePage.selectBankCardOption();
		loginPage.scrollScreen();
		homePage.clickPaymentProceedButton();
		homePage.clickCouponProceedButton();
		homePage.switchToWebview();
		loginPage.closeKeyboard();
		loginPage.ConfirmPopup();
		homePage.clickHomeIcon();
		Assert.assertTrue(loginPage.isMobileTabPresent(), "verification of Loggedin screen is failed");
	}
	
	@Test(priority=2)
	public void testDTHRecharge(){
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		
		homePage.clickDTHTab();
		homePage.selectServiceProvider();
		homePage.typeCustomerID("90163458");
		loginPage.closeKeyboard();
		loginPage.scrollScreen();
		homePage.clickDTHProceedButton();
		homePage.clickConfirmPopup();
		homePage.typeDTHRechargeAmount("275");
		loginPage.closeKeyboard();
		homePage.clickAmountDTH_ProceedButton();
		homePage.selectPaymentMethod();
		homePage.selectBankCardOption();
		loginPage.scrollScreen();
		homePage.clickPaymentProceedButton();
		homePage.clickCouponProceedButton();
		homePage.switchToWebview();
		loginPage.closeKeyboard();
		loginPage.ConfirmPopup();
		homePage.clickHomeIcon();
		Assert.assertTrue(loginPage.isMobileTabPresent(), "verification of Loggedin screen is failed");
	}

}
