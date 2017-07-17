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
		//Assert.assertTrue(editWalletPage.isPinChanged(), "No confirmation message appears");
		//editWalletPage.clickOKButton();
		Assert.assertTrue(rincashPage.isRINcashWalletPageOpened(), "RINcash page is not opened");
		rincashPage.clickEditDetailsButton();
		editWalletPage.clickEditPinNoTab();
		editWalletPage.enterOldPin(config.getProperty("New_Pin"));
		editWalletPage.enterNewPin(config.getProperty("RIN_Pin"));
		editWalletPage.enterConfirmPin(config.getProperty("RIN_Pin"));
		editWalletPage.clickPinProceedButton();
		//Assert.assertTrue(editWalletPage.isPinChanged(), "No confirmation message appears");
		//editWalletPage.clickOKButton();
		Assert.assertTrue(rincashPage.isRINcashWalletPageOpened(), "RINcash page is not opened");
		rincashPage.switchParentWindow1();
	}

}
