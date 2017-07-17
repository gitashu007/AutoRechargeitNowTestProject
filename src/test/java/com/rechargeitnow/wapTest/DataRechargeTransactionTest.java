package com.rechargeitnow.wapTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rechargeitnow.pages.TestCore;
import com.rechargeitnow.projectPages.HomePageWap;
import com.rechargeitnow.projectPages.LandingPageWap;
import com.rechargeitnow.projectPages.LoginPageWap;
import com.rechargeitnow.projectPages.MobileRechargeAmountPageWap;
import com.rechargeitnow.projectPages.PaymentGatewayPage;
import com.rechargeitnow.projectPages.PaymentPageWap;
import com.rechargeitnow.projectPages.ReceiptPageWap;
import com.rechargeitnow.projectPages.SummaryPageWap;

public class DataRechargeTransactionTest extends TestCore{

	@Test(priority=0)
	public void testDataRechargeFlow_PDCPromoPGScen21(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickDataRechargeTypeButton();
		landingPage.enterMobileNumberData(config.getProperty("Data_MobileNumber"));
		landingPage.clickSubmitButtonData2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperatorData(config.getProperty("Data_Operator"));
		landingPage.selectDataCircle(config.getProperty("Data_Circle"));
		landingPage.clickSubmitButtonData();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Data_MobileNumber")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("10");
		rechargeAmountPage.clickProceedButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("10"), "Payable amount is wrong on payment page");
		paymentPage.applyPromoCode(config.getProperty("Promo_Code"));
		Assert.assertTrue(paymentPage.isConfirmationAppears(), "No confirmation message appears");

		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		Assert.assertTrue(summaryPage.isPDCapplied(), "Partner Discount Coupon is not applied");
		Assert.assertTrue(summaryPage.isPromoApplied(), "Promo is not applied");
		Assert.assertTrue(paymentPage.isPayableAmountPaymentPagePresent("19"), "Payable amount is not shown");
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Mobile_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");

	}
	@Test(priority=1)
	public void testDataRechargeFlow_PGScen22(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickDataRechargeTypeButton();
		landingPage.enterMobileNumberData(config.getProperty("Data_MobileNumber"));
		landingPage.clickSubmitButtonData2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperatorData(config.getProperty("Data_Operator"));
		landingPage.selectDataCircle(config.getProperty("Data_Circle"));
		landingPage.clickSubmitButtonData();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Data_MobileNumber")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount(config.getProperty("Recharge_Amount"));
		rechargeAmountPage.clickProceedButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountCorrect(), "Recharge amount is wrong on payment page");
		paymentPage.clickPDCCheckBox();
		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();
		paymentPage.clickPDCProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();
		
		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Mobile_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");

	}
	@Test(priority=2)
	public void testDataRechargeFlow_CouponPGScen23(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickDataRechargeTypeButton();
		landingPage.enterMobileNumberData(config.getProperty("Data_MobileNumber"));
		landingPage.clickSubmitButtonData2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperatorData(config.getProperty("Data_Operator"));
		landingPage.selectDataCircle(config.getProperty("Data_Circle"));
		landingPage.clickSubmitButtonData();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Data_MobileNumber")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("15");
		rechargeAmountPage.applyCouponCode(config.getProperty("Coupon_No"), config.getProperty("Coupon_Amount"), config.getProperty("Coupon_Code"));
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickYesRadioButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("5"), "Payable amount is wrong on payment page");
		paymentPage.clickPDCCheckBox();

		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		Assert.assertTrue(paymentPage.isPayableAmountPaymentData("5"), "Payable amount is not shown");
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();
		Assert.assertTrue(paymentPage.isNetPayableAmountExpected(), "payable amount on summary page and PDC page are different");
		paymentPage.clickPDCProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Mobile_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		Assert.assertTrue(receiptPage.verifyReceiptCouponValueLoc3(), "Coupon value is not applied ");
	}

	@Test(priority=3)
	public void testDataRechargeFlow_PGandPDCScen24(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickDataRechargeTypeButton();
		landingPage.enterMobileNumberData(config.getProperty("Data_MobileNumber"));
		landingPage.clickSubmitButtonData2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperatorData(config.getProperty("Data_Operator"));
		landingPage.selectDataCircle(config.getProperty("Data_Circle"));
		landingPage.clickSubmitButtonData();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Data_MobileNumber")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("10");
		rechargeAmountPage.clickProceedButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("10"), "Payable amount is wrong on payment page");

		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		Assert.assertTrue(summaryPage.isPDCapplied(), "PDC is not displayed");
		Assert.assertTrue(paymentPage.isPayableAmountPaymentScen6("20"), "Payable amount is not shown");
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Mobile_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
	}
	@Test(priority=4)
	public void testDataRechargeFlow_CouponPDCandPGScen25(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickDataRechargeTypeButton();
		landingPage.enterMobileNumberData(config.getProperty("Data_MobileNumber"));
		landingPage.clickSubmitButtonData2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperatorData(config.getProperty("Data_Operator"));
		landingPage.selectDataCircle(config.getProperty("Data_Circle"));
		landingPage.clickSubmitButtonData();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Data_MobileNumber")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("15");
		rechargeAmountPage.applyCouponCode(config.getProperty("Coupon_No"), config.getProperty("Coupon_Amount"), config.getProperty("Coupon_Code"));
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickYesRadioButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("5"), "Payable amount is wrong on payment page");

		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		Assert.assertTrue(summaryPage.isPDCapplied(), "PDC is not displayed");
		Assert.assertTrue(paymentPage.isPayableAmountPaymentScen6("15"), "Payable amount is not shown");
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Mobile_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
	}
	
	@Test(priority=5)
	public void testDataRechargeFlow_CpnPDCPromoRINandPGScen26(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickDataRechargeTypeButton();
		landingPage.enterMobileNumberData(config.getProperty("Data_MobileNumber"));
		landingPage.clickSubmitButtonData2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperatorData(config.getProperty("Data_Operator"));
		landingPage.selectDataCircle(config.getProperty("Data_Circle"));
		landingPage.clickSubmitButtonData();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Data_MobileNumber")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("15");
		rechargeAmountPage.applyCouponCode(config.getProperty("Coupon_No"), config.getProperty("Coupon_Amount"), config.getProperty("Coupon_Code"));
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickYesRadioButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("5"), "Payable amount is wrong on payment page");
		paymentPage.applyPromoCode(config.getProperty("Promo_Code"));
		Assert.assertTrue(paymentPage.isConfirmationAppears(), "No Promo confirmation is shown");
		paymentPage.enterRINcashAmount("1");
		paymentPage.enterRINPin(config.getProperty("RIN_Pin"));
		
		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		Assert.assertTrue(summaryPage.isPDCapplied(), "PDC is not displayed");
		Assert.assertTrue(summaryPage.isPromoApplied(), "Promo verification is failed");
		Assert.assertTrue(summaryPage.isappliedRINcashDisplayedData(), "Verification of RINcash amount is failed");
		Assert.assertTrue(paymentPage.isPayableAmountPaymentData2("13"), "Payable amount is not shown");
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Mobile_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		Assert.assertTrue(receiptPage.verifyReceiptCouponValueLoc3(), "Coupon value is not applied ");
	}
	@Test(priority=6)
	public void testDataRechargeFlow_RINcashPGPromoAndPDCScen31(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickDataRechargeTypeButton();
		landingPage.enterMobileNumberData(config.getProperty("Data_MobileNumber"));
		landingPage.clickSubmitButtonData2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperatorData(config.getProperty("Data_Operator"));
		landingPage.selectDataCircle(config.getProperty("Data_Circle"));
		landingPage.clickSubmitButtonData();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Data_MobileNumber")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("10");
		rechargeAmountPage.clickProceedButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("10"), "Payable amount is wrong on payment page");
		paymentPage.applyPromoCode(config.getProperty("Promo_Code"));
		Assert.assertTrue(paymentPage.isConfirmationAppears(), "No Promo confirmation is shown");
		paymentPage.enterRINcashAmount("1");
		paymentPage.enterRINPin(config.getProperty("RIN_Pin"));
		
		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		Assert.assertTrue(summaryPage.isPDCapplied(), "PDC is not displayed");
		Assert.assertTrue(summaryPage.isPromoApplied(), "Promo verification is failed");
		Assert.assertTrue(summaryPage.isappliedRINcashDisplayedData(), "Verification of RINcash amount is failed");
		Assert.assertTrue(paymentPage.isPayableAmountPaymentData2("18"), "Payable amount is not shown");
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Mobile_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
	}

}
