package com.rechargeitnow.wapTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rechargeitnow.pages.TestCore;
import com.rechargeitnow.projectPages.EditWalletDetailsPageWap;
import com.rechargeitnow.projectPages.HomePageWap;
import com.rechargeitnow.projectPages.LoginPageWap;
import com.rechargeitnow.projectPages.MyAccountPageWap;
import com.rechargeitnow.projectPages.RINcashTransactionPageWap;

public class RINcashWalletPinEditTest extends TestCore {
	@Test(priority=0)
	public void testRINcashWalletPinEdit_WithBlankPinField(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");
		
		homePage.clickMyAccountButton();
		MyAccountPageWap myAccountPage = new MyAccountPageWap(driver);
		myAccountPage.clickRINcashWalletButton();
		
		RINcashTransactionPageWap rincashPage = new RINcashTransactionPageWap(driver);
		Assert.assertTrue(rincashPage.isRINcashWalletPageOpened(), "RINcash page is not opened");
		rincashPage.clickEditDetailsButton();
		
		EditWalletDetailsPageWap editWalletPage = new EditWalletDetailsPageWap(driver);
		editWalletPage.clickEditPinNoTab();
		editWalletPage.clickPinProceedButton();
		Assert.assertTrue(editWalletPage.verifyPinValidation("please enter a pin"), "Expected validation message doesn't appears");
		rincashPage.switchParentWindow1();
		myAccountPage.clickLogoutIcon();
	}
	@Test(priority=1)
	public void testRINcashWalletPinEdit_WithInvalidPin(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");
		
		homePage.clickMyAccountButton();
		MyAccountPageWap myAccountPage = new MyAccountPageWap(driver);
		myAccountPage.clickRINcashWalletButton();
		
		RINcashTransactionPageWap rincashPage = new RINcashTransactionPageWap(driver);
		Assert.assertTrue(rincashPage.isRINcashWalletPageOpened(), "RINcash page is not opened");
		rincashPage.clickEditDetailsButton();
		
		EditWalletDetailsPageWap editWalletPage = new EditWalletDetailsPageWap(driver);
		editWalletPage.clickEditPinNoTab();
		editWalletPage.enterOldPin("1111");
		editWalletPage.enterNewPin(config.getProperty("New_Pin"));
		editWalletPage.enterConfirmPin(config.getProperty("New_Pin"));
		editWalletPage.clickPinProceedButton();
		Assert.assertTrue(editWalletPage. verifyEditPinValidation("pin does not match. please retry"), "Expected validation message doesn't appears");
		rincashPage.switchParentWindow1();
		myAccountPage.clickLogoutIcon();
	}
	@Test(priority=2)
	public void testRINcashWalletPinEdit_WithDifferentInputNewAndConfirmPin(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");
		
		homePage.clickMyAccountButton();
		MyAccountPageWap myAccountPage = new MyAccountPageWap(driver);
		myAccountPage.clickRINcashWalletButton();
		
		RINcashTransactionPageWap rincashPage = new RINcashTransactionPageWap(driver);
		Assert.assertTrue(rincashPage.isRINcashWalletPageOpened(), "RINcash page is not opened");
		rincashPage.clickEditDetailsButton();
		
		EditWalletDetailsPageWap editWalletPage = new EditWalletDetailsPageWap(driver);
		editWalletPage.clickEditPinNoTab();
		editWalletPage.enterOldPin(config.getProperty("RIN_Pin"));
		editWalletPage.enterNewPin(config.getProperty("New_Pin"));
		editWalletPage.enterConfirmPin("1111");
		editWalletPage.clickPinProceedButton();
		Assert.assertTrue(editWalletPage. verifyPinValidation("new pin and confirm pin do not match. please retry"), "Expected validation message doesn't appears");
		rincashPage.switchParentWindow1();
		myAccountPage.clickLogoutIcon();
	}
	@Test(priority=3)
	public void testRINcashWalletPinEdit_WithShortNewAndConfirmPin(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");
		
		homePage.clickMyAccountButton();
		MyAccountPageWap myAccountPage = new MyAccountPageWap(driver);
		myAccountPage.clickRINcashWalletButton();
		
		RINcashTransactionPageWap rincashPage = new RINcashTransactionPageWap(driver);
		Assert.assertTrue(rincashPage.isRINcashWalletPageOpened(), "RINcash page is not opened");
		rincashPage.clickEditDetailsButton();
		
		EditWalletDetailsPageWap editWalletPage = new EditWalletDetailsPageWap(driver);
		editWalletPage.clickEditPinNoTab();
		editWalletPage.enterOldPin(config.getProperty("RIN_Pin"));
		editWalletPage.enterNewPin("11");
		editWalletPage.enterConfirmPin("11");
		editWalletPage.clickPinProceedButton();
		Assert.assertTrue(editWalletPage.verifyPinValidation("pin length should be between 4-6 digits"), "Expected validation message doesn't appears");
		rincashPage.switchParentWindow1();
		myAccountPage.clickLogoutIcon();
	}
	@Test(priority=4)
	public void testRINcashWalletPinEdit_WithSameInputAllFields(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");
		
		homePage.clickMyAccountButton();
		MyAccountPageWap myAccountPage = new MyAccountPageWap(driver);
		myAccountPage.clickRINcashWalletButton();
		
		RINcashTransactionPageWap rincashPage = new RINcashTransactionPageWap(driver);
		Assert.assertTrue(rincashPage.isRINcashWalletPageOpened(), "RINcash page is not opened");
		rincashPage.clickEditDetailsButton();
		
		EditWalletDetailsPageWap editWalletPage = new EditWalletDetailsPageWap(driver);
		editWalletPage.clickEditPinNoTab();
		editWalletPage.enterOldPin(config.getProperty("RIN_Pin"));
		editWalletPage.enterNewPin(config.getProperty("RIN_Pin"));
		editWalletPage.enterConfirmPin(config.getProperty("RIN_Pin"));
		editWalletPage.clickPinProceedButton();
		Assert.assertTrue(editWalletPage.verifyPinValidation("new pin must be different from old pin"), "Expected validation message doesn't appears");
		rincashPage.switchParentWindow1();
		myAccountPage.clickLogoutIcon();
	}
	@Test(priority=5)
	public void testRINcashWalletPinEdit_WithValidInputs(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");
		
		homePage.clickMyAccountButton();
		MyAccountPageWap myAccountPage = new MyAccountPageWap(driver);
		myAccountPage.clickRINcashWalletButton();
		
		RINcashTransactionPageWap rincashPage = new RINcashTransactionPageWap(driver);
		Assert.assertTrue(rincashPage.isRINcashWalletPageOpened(), "RINcash page is not opened");
		rincashPage.clickEditDetailsButton();
		
		EditWalletDetailsPageWap editWalletPage = new EditWalletDetailsPageWap(driver);
		editWalletPage.clickEditPinNoTab();
		editWalletPage.enterOldPin(config.getProperty("RIN_Pin"));
		editWalletPage.enterNewPin(config.getProperty("New_Pin"));
		editWalletPage.enterConfirmPin(config.getProperty("New_Pin"));
		editWalletPage.clickPinProceedButton();
		Assert.assertTrue(editWalletPage.isPinChanged(), "No confirmation message appears");
		editWalletPage.clickOKButton();
		Assert.assertTrue(rincashPage.isRINcashWalletPageOpened(), "RINcash page is not opened");
		rincashPage.clickEditDetailsButton();
		editWalletPage.clickEditPinNoTab();
		editWalletPage.enterOldPin(config.getProperty("New_Pin"));
		editWalletPage.enterNewPin(config.getProperty("RIN_Pin"));
		editWalletPage.enterConfirmPin(config.getProperty("RIN_Pin"));
		editWalletPage.clickPinProceedButton();
		Assert.assertTrue(editWalletPage.isPinChanged(), "No confirmation message appears");
		editWalletPage.clickOKButton();
		Assert.assertTrue(rincashPage.isRINcashWalletPageOpened(), "RINcash page is not opened");
		rincashPage.switchParentWindow1();
		rincashPage.switchParentWindow1();
		myAccountPage.clickLogoutIcon();
	}

}
