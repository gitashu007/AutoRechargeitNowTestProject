package com.rechargeitnow.wapTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rechargeitnow.pageObject.PaymentPageWapObject;
import com.rechargeitnow.pages.TestCore;
import com.rechargeitnow.projectPages.HomePageWap;
import com.rechargeitnow.projectPages.LandingPageWap;
import com.rechargeitnow.projectPages.LoginPageWap;
import com.rechargeitnow.projectPages.MobileRechargeAmountPageWap;
import com.rechargeitnow.projectPages.PaymentGatewayPage;
import com.rechargeitnow.projectPages.PaymentPageWap;
import com.rechargeitnow.projectPages.ReceiptPageWap;
import com.rechargeitnow.projectPages.SummaryPageWap;

public class MobileRechargeTransactionTest extends TestCore{

	
	@Test(priority=0)
	public void testRechargeFlow_withCouponOnly(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("mobile");
		landingPage.enterMobileNumber(config.getProperty("Mobile_Number"));
		landingPage.clickSubmitButton2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperator(config.getProperty("Mobile_Operator"));
		landingPage.selectCircle(config.getProperty("Circle"));
		landingPage.clickSubmitButton3();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("10");
		rechargeAmountPage.applyCouponCode(config.getProperty("Coupon_No"), config.getProperty("Coupon_Amount"), config.getProperty("Coupon_Code"));
		rechargeAmountPage.clickProceedButton();

		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.clickProceedSummaryButton();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		receiptPage.clickHereToStopLink();
	    Assert.assertTrue(receiptPage.isOrderIdPresent(), "Order id is not present on receipt");
	    Assert.assertTrue(receiptPage.isMobileNoSame(config.getProperty("Mobile_Number")),"Mobile no. is different on receipt page");
	    Assert.assertTrue(receiptPage.isRechargeAmountSame("10"), "Recharge amount is different on receipt page");
	    Assert.assertTrue(receiptPage.verifyCouponValue(), "verification of Coupon is failed");
	    receiptPage.clickRINLogo();

	}

	@Test(priority=1)
	public void testRechargeFlow_WithCouponRINcash(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("mobile");
		landingPage.enterMobileNumber(config.getProperty("Mobile_Number"));
		landingPage.clickSubmitButton2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperator(config.getProperty("Mobile_Operator"));
		landingPage.selectCircle(config.getProperty("Circle"));
		landingPage.clickSubmitButton3();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("15");
		rechargeAmountPage.applyCouponCode(config.getProperty("Coupon_No"), config.getProperty("Coupon_Amount"), config.getProperty("Coupon_Code"));
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickYesRadioButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("5"), "Payable amount is wrong on payment page");
		paymentPage.clickPDCCheckBox();
		paymentPage.enterRINcashAmount("5");
		paymentPage.enterRINPin(config.getProperty("RIN_Pin"));
		paymentPage.clickProceedButton();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		receiptPage.clickHereToStopLink();
		Assert.assertTrue(receiptPage.isOrderIdPresent(), "Order id is not present on receipt");
		Assert.assertTrue(receiptPage.isMobileNoSame(config.getProperty("Mobile_Number")),"Mobile no. is different on receipt page");
		Assert.assertTrue(receiptPage.isRechargeAmountSame("15"), "Recharge amount is different on receipt page");
		Assert.assertTrue(receiptPage.isRINcashPointDisplayed("5"), "RINcash points are not displayed");
		Assert.assertTrue(receiptPage.verifyReceiptCouponValue(), "Coupon value is not applied ");
		receiptPage.clickRINLogo();
	}

	@Test(priority=2)
	public void testRechargeFlow_CouponPromoRINcash(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("mobile");
		landingPage.enterMobileNumber(config.getProperty("Mobile_Number"));
		landingPage.clickSubmitButton2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperator(config.getProperty("Mobile_Operator"));
		landingPage.selectCircle(config.getProperty("Circle"));
		landingPage.clickSubmitButton3();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("15");
		rechargeAmountPage.applyCouponCode(config.getProperty("Coupon_No"), config.getProperty("Coupon_Amount"), config.getProperty("Coupon_Code"));
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickYesRadioButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("5"), "Payable amount is wrong on payment page");
		paymentPage.clickPDCCheckBox();
		paymentPage.applyPromoCode(config.getProperty("Promo_Code"));
		Assert.assertTrue(paymentPage.isConfirmationAppears(), "No confirmation message appears");
		paymentPage.enterRINcashAmount("4");
		paymentPage.enterRINPin(config.getProperty("RIN_Pin"));
		paymentPage.clickProceedButton();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		receiptPage.clickHereToStopLink();
		Assert.assertTrue(receiptPage.isOrderIdPresent(), "Order id is not present on receipt");
		Assert.assertTrue(receiptPage.isMobileNoSame(config.getProperty("Mobile_Number")),"Mobile no. is different on receipt page");
		Assert.assertTrue(receiptPage.isRechargeAmountSame("15"), "Recharge amount is different on receipt page");
		receiptPage.clickRINLogo();
	}

	@Test(priority=3)
	public void testRechargeFlow_CouponPromoRINcashPG(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("mobile");
		landingPage.enterMobileNumber(config.getProperty("Mobile_Number"));
		landingPage.clickSubmitButton2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperator(config.getProperty("Mobile_Operator"));
		landingPage.selectCircle(config.getProperty("Circle"));
		landingPage.clickSubmitButton3();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("19");
		rechargeAmountPage.applyCouponCode(config.getProperty("Coupon_No"), config.getProperty("Coupon_Amount"), config.getProperty("Coupon_Code"));
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickYesRadioButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("9"), "Payable amount is wrong on payment page");
		paymentPage.clickPDCCheckBox();
		paymentPage.applyPromoCode(config.getProperty("Promo_Code"));
		Assert.assertTrue(paymentPage.isConfirmationAppears(), "No confirmation message appears");
		paymentPage.enterRINcashAmount("1");
		paymentPage.enterRINPin(config.getProperty("RIN_Pin"));
		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		Assert.assertTrue(summaryPage.isAppliedPromoDisplayed(), "Promo code is not applied");
		Assert.assertTrue(summaryPage.isappliedRINcashDisplayed(), "RINcash is not applied");
		Assert.assertTrue(paymentPage.isPayableAmountPaymentPagePresent("7"), "Payable amount is not shown");
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();
		Assert.assertTrue(paymentPage.isNetPayableAmountExpected(), "payable amount on summary page and PDC page are different");
		paymentPage.clickPDCProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickRINUrl();
		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Mobile_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		receiptPage.clickStartAgainButton();

	}

	@Test(priority=4)
	public void testRechargeFlow_CouponPromo(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("mobile");
		landingPage.enterMobileNumber(config.getProperty("Mobile_Number"));
		landingPage.clickSubmitButton2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperator(config.getProperty("Mobile_Operator"));
		landingPage.selectCircle(config.getProperty("Circle"));
		landingPage.clickSubmitButton3();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("16");
		rechargeAmountPage.applyCouponCode(config.getProperty("Coupon_No"), config.getProperty("Coupon_Amount"), config.getProperty("Coupon_Code"));
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickYesRadioButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("6"), "Payable amount is wrong on payment page");
		paymentPage.clickPDCCheckBox();
		paymentPage.applyPromoCode(config.getProperty("Promo_Code"));
		Assert.assertTrue(paymentPage.isConfirmationAppears(), "No confirmation message appears");

		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		Assert.assertTrue(summaryPage.isAppliedPromoDisplayed(), "Promo code is not applied");
		Assert.assertTrue(paymentPage.isPayableAmountPaymentScen6("5"), "Payable amount is not shown");
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();
		Assert.assertTrue(paymentPage.isNetPayableAmountExpected(), "payable amount on summary page and PDC page are different");
		paymentPage.clickPDCProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickRINUrl();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Mobile_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		receiptPage.clickStartAgainButton();
	}

	@Test(priority=5)
	public void testRechargeFlow_CouponPDCPromoPG(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("mobile");
		landingPage.enterMobileNumber(config.getProperty("Mobile_Number"));
		landingPage.clickSubmitButton2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperator(config.getProperty("Mobile_Operator"));
		landingPage.selectCircle(config.getProperty("Circle"));
		landingPage.clickSubmitButton3();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("15");
		rechargeAmountPage.applyCouponCode(config.getProperty("Coupon_No"), config.getProperty("Coupon_Amount"), config.getProperty("Coupon_Code"));
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickYesRadioButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("5"), "Payable amount is wrong on payment page");
		paymentPage.applyPromoCode(config.getProperty("Promo_Code"));
		Assert.assertTrue(paymentPage.isConfirmationAppears(), "No confirmation message appears");

		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		Assert.assertTrue(summaryPage.isPDCapplied(), "Partner Discount Coupon is not applied");
		Assert.assertTrue(summaryPage.isPromoApplied(), "Promo code is not applied");
		Assert.assertTrue(paymentPage.isPayableAmountPaymentScen6("14"), "Payable amount is not shown");
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickRINUrl();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Mobile_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		receiptPage.clickStartAgainButton();
	}

	@Test(priority=6)
	public void testRechargeFlow_CouponRINcashPG(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("mobile");
		landingPage.enterMobileNumber(config.getProperty("Mobile_Number"));
		landingPage.clickSubmitButton2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperator(config.getProperty("Mobile_Operator"));
		landingPage.selectCircle(config.getProperty("Circle"));
		landingPage.clickSubmitButton3();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("16");
		rechargeAmountPage.applyCouponCode(config.getProperty("Coupon_No"), config.getProperty("Coupon_Amount"), config.getProperty("Coupon_Code"));
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickYesRadioButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("6"), "Payable amount is wrong on payment page");
		paymentPage.clickPDCCheckBox();
		paymentPage.enterRINcashAmount("1");
		paymentPage.enterRINPin(config.getProperty("RIN_Pin"));

		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		Assert.assertTrue(summaryPage.isRINcashApplied("1"), "RINcash is not applied");
		Assert.assertTrue(paymentPage.isPayableAmountPaymentScen6("5"), "Payable amount is not shown");
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();
		Assert.assertTrue(paymentPage.isNetPayableAmountExpected(), "payable amount on summary page and PDC page are different");
		paymentPage.clickPDCProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickRINUrl();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Mobile_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		receiptPage.clickStartAgainButton();
	}

	@Test(priority=7)
	public void testRechargeFlow_CouponPDCRINcashPG(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("mobile");
		landingPage.enterMobileNumber(config.getProperty("Mobile_Number"));
		landingPage.clickSubmitButton2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperator(config.getProperty("Mobile_Operator"));
		landingPage.selectCircle(config.getProperty("Circle"));
		landingPage.clickSubmitButton3();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("15");
		rechargeAmountPage.applyCouponCode(config.getProperty("Coupon_No"), config.getProperty("Coupon_Amount"), config.getProperty("Coupon_Code"));
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickYesRadioButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("5"), "Payable amount is wrong on payment page");
		paymentPage.enterRINcashAmount("1");
		paymentPage.enterRINPin(config.getProperty("RIN_Pin"));

		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		Assert.assertTrue(summaryPage.isPDCapplied(), "Partner Discount Coupon is not applied");
		Assert.assertTrue(summaryPage.isRINcashAppliedPDC(), "RINcash is not applied");
		Assert.assertTrue(paymentPage.isPayableAmountPaymentPagePresent("14"), "Payable amount is not shown");
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickRINUrl();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Mobile_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		receiptPage.clickStartAgainButton();
	}

	@Test(priority=8)
	public void testRechargeFlow_CouponRincashPromoPDC(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("mobile");
		landingPage.enterMobileNumber(config.getProperty("Mobile_Number"));
		landingPage.clickSubmitButton2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperator(config.getProperty("Mobile_Operator"));
		landingPage.selectCircle(config.getProperty("Circle"));
		landingPage.clickSubmitButton3();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("15");
		rechargeAmountPage.applyCouponCode(config.getProperty("Coupon_No"), config.getProperty("Coupon_Amount"), config.getProperty("Coupon_Code"));
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickYesRadioButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("5"), "Payable amount is wrong on payment page");
		paymentPage.applyPromoCode(config.getProperty("Promo_Code"));
		Assert.assertTrue(paymentPage.isConfirmationAppears(), "No confirmation message appears");
		paymentPage.enterRINcashAmount("14");
		paymentPage.enterRINPin(config.getProperty("RIN_Pin"));
		paymentPage.clickProceedButton();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		receiptPage.clickHereToStopLink();
		Assert.assertTrue(receiptPage.isOrderIdPresent(), "Order id is not present on receipt");
		Assert.assertTrue(receiptPage.isMobileNoSame(config.getProperty("Mobile_Number")),"Mobile no. is different on receipt page");
		Assert.assertTrue(receiptPage.isRechargeAmountSame("15"), "Recharge amount is different on receipt page");
		Assert.assertTrue(receiptPage.isRINcashPointDisplayed("14"), "RINcash points are not displayed");
		Assert.assertTrue(receiptPage.verifyReceiptCouponValueLoc2(), "Coupon value is not applied ");
		receiptPage.clickRINLogo();
	}

	@Test(priority=9)
	public void testRechargeFlow_RINcash(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("mobile");
		landingPage.enterMobileNumber(config.getProperty("Mobile_Number"));
		landingPage.clickSubmitButton2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperator(config.getProperty("Mobile_Operator"));
		landingPage.selectCircle(config.getProperty("Circle"));
		landingPage.clickSubmitButton3();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("10");
		rechargeAmountPage.clickProceedButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("10"), "Payable amount is wrong on payment page");
		paymentPage.clickPDCCheckBox();
		paymentPage.applyPromoCode(config.getProperty("Promo_Code"));
		Assert.assertTrue(paymentPage.isConfirmationAppears(), "No confirmation message appears");
		paymentPage.enterRINcashAmount("9");
		paymentPage.enterRINPin(config.getProperty("RIN_Pin"));
		paymentPage.clickProceedButton();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		receiptPage.clickHereToStopLink();
		Assert.assertTrue(receiptPage.isOrderIdPresent(), "Order id is not present on receipt");
		Assert.assertTrue(receiptPage.isMobileNoSame(config.getProperty("Mobile_Number")),"Mobile no. is different on receipt page");
		Assert.assertTrue(receiptPage.isRechargeAmountSame("10"), "Recharge amount is different on receipt page");
		Assert.assertTrue(receiptPage.isRINcashPointDisplayed("10"), "RINcash points are not displayed");
		receiptPage.clickRINLogo();

	}

	@Test(priority=10)
	public void testRechargeFlow_RINPromo(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("mobile");
		landingPage.enterMobileNumber(config.getProperty("Mobile_Number"));
		landingPage.clickSubmitButton2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperator(config.getProperty("Mobile_Operator"));
		landingPage.selectCircle(config.getProperty("Circle"));
		landingPage.clickSubmitButton3();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("10");
		rechargeAmountPage.clickProceedButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("10"), "Payable amount is wrong on payment page");
		paymentPage.clickPDCCheckBox();
		paymentPage.applyPromoCode(config.getProperty("Promo_Code"));
		Assert.assertTrue(paymentPage.isConfirmationAppears(), "No confirmation message appears");
		paymentPage.enterRINcashAmount("9");
		paymentPage.enterRINPin(config.getProperty("RIN_Pin"));
		paymentPage.clickProceedButton();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		receiptPage.clickHereToStopLink();
		Assert.assertTrue(receiptPage.isOrderIdPresent(), "Order id is not present on receipt");
		Assert.assertTrue(receiptPage.isMobileNoSame(config.getProperty("Mobile_Number")),"Mobile no. is different on receipt page");
		Assert.assertTrue(receiptPage.isRechargeAmountSame("10"), "Recharge amount is different on receipt page");
		Assert.assertTrue(receiptPage.isRINcashPointDisplayed("9"), "RINcash points are not displayed");
		receiptPage.clickRINLogo();

	}

	@Test(priority=11)
	public void testRechargeFlow_RINPG(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("mobile");
		landingPage.enterMobileNumber(config.getProperty("Mobile_Number"));
		landingPage.clickSubmitButton2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperator(config.getProperty("Mobile_Operator"));
		landingPage.selectCircle(config.getProperty("Circle"));
		landingPage.clickSubmitButton3();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("10");
		rechargeAmountPage.clickProceedButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("10"), "Payable amount is wrong on payment page");
		paymentPage.clickPDCCheckBox();
		paymentPage.enterRINcashAmount("1");
		paymentPage.enterRINPin(config.getProperty("RIN_Pin"));
		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		Assert.assertTrue(summaryPage.isRINcashApplied("1"), "RINcash is not applied");
		Assert.assertTrue(paymentPage.isPayableAmountPaymentScen6("9"), "Payable amount is not shown");
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();
		//Assert.assertTrue(paymentPage.isNetPayableAmountExpected(), "payable amount on summary page and PDC page are different");
		paymentPage.clickPDCProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickRINUrl();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Mobile_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		receiptPage.clickRINLogo();
	}

	@Test(priority=12)
	public void testRechargeFlow_RINcashPDC(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("mobile");
		landingPage.enterMobileNumber(config.getProperty("Mobile_Number"));
		landingPage.clickSubmitButton2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperator(config.getProperty("Mobile_Operator"));
		landingPage.selectCircle(config.getProperty("Circle"));
		landingPage.clickSubmitButton3();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("10");
		rechargeAmountPage.clickProceedButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("10"), "Payable amount is wrong on payment page");
		paymentPage.enterRINcashAmount("20");
		paymentPage.enterRINPin(config.getProperty("RIN_Pin"));

		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		receiptPage.clickHereToStopLink();
		Assert.assertTrue(receiptPage.isOrderIdPresent(), "Order id is not present on receipt");
		Assert.assertTrue(receiptPage.isMobileNoSame(config.getProperty("Mobile_Number")),"Mobile no. is different on receipt page");
		Assert.assertTrue(receiptPage.isRechargeAmountSame("10"), "Recharge amount is different on receipt page");
		receiptPage.clickRINLogo();
	}
	@Test(priority=13)
	public void testRechargeFlow_CouponRINcashPDC(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("mobile");
		landingPage.enterMobileNumber(config.getProperty("Mobile_Number"));
		landingPage.clickSubmitButton2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperator(config.getProperty("Mobile_Operator"));
		landingPage.selectCircle(config.getProperty("Circle"));
		landingPage.clickSubmitButton3();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("15");
		rechargeAmountPage.applyCouponCode(config.getProperty("Coupon_No"), config.getProperty("Coupon_Amount"), config.getProperty("Coupon_Code"));
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickYesRadioButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("5"), "Payable amount is wrong on payment page");
		paymentPage.enterRINcashAmount("15");
		paymentPage.enterRINPin(config.getProperty("RIN_Pin"));

		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		receiptPage.clickHereToStopLink();
		Assert.assertTrue(receiptPage.isOrderIdPresent(), "Order id is not present on receipt");
		Assert.assertTrue(receiptPage.isMobileNoSame(config.getProperty("Mobile_Number")),"Mobile no. is different on receipt page");
		Assert.assertTrue(receiptPage.isRechargeAmountSame("15"), "Recharge amount is different on receipt page");
		receiptPage.clickRINLogo();
	}
	@Test(priority=14)
	public void testRechargeFlow_RINcashPromoPG(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("mobile");
		landingPage.enterMobileNumber(config.getProperty("Mobile_Number"));
		landingPage.clickSubmitButton2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperator(config.getProperty("Mobile_Operator"));
		landingPage.selectCircle(config.getProperty("Circle"));
		landingPage.clickSubmitButton3();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("10");
		rechargeAmountPage.clickProceedButton();
		
		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("10"), "Payable amount is wrong on payment page");
		paymentPage.clickPDCCheckBox();
		paymentPage.applyPromoCode(config.getProperty("Promo_Code"));
		Assert.assertTrue(paymentPage.isConfirmationAppears(), "No confirmation message appears");
		paymentPage.enterRINcashAmount("1");
		paymentPage.enterRINPin(config.getProperty("RIN_Pin"));

		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();
		
		Assert.assertTrue(summaryPage.isRINcashApplied("1"), "RINcash is not applied");
		Assert.assertTrue(summaryPage.isPromoApplied(), "Promo code is not applied");
		Assert.assertTrue(paymentPage.isPayableAmountPaymentPagePresent("8"), "Payable amount is not shown");
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();
		Assert.assertTrue(paymentPage.isNetPayableAmountExpected(), "payable amount on summary page and PDC page are different");
		paymentPage.clickPDCProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickRINUrl();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Mobile_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		receiptPage.clickStartAgainButton();
		
	}
	
	@Test(priority=15)
	public void testRechargeFlow_RINcashPromoPDC(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("mobile");
		landingPage.enterMobileNumber(config.getProperty("Mobile_Number"));
		landingPage.clickSubmitButton2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperator(config.getProperty("Mobile_Operator"));
		landingPage.selectCircle(config.getProperty("Circle"));
		landingPage.clickSubmitButton3();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("10");
		rechargeAmountPage.clickProceedButton();
		
		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("10"), "Payable amount is wrong on payment page");
		paymentPage.applyPromoCode(config.getProperty("Promo_Code"));
		Assert.assertTrue(paymentPage.isConfirmationAppears(), "No confirmation message appears");
		paymentPage.enterRINcashAmount("19");
		paymentPage.enterRINPin(config.getProperty("RIN_Pin"));
		paymentPage.clickProceedButton();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		receiptPage.clickHereToStopLink();
		Assert.assertTrue(receiptPage.isOrderIdPresent(), "Order id is not present on receipt");
		Assert.assertTrue(receiptPage.isMobileNoSame(config.getProperty("Mobile_Number")),"Mobile no. is different on receipt page");
		Assert.assertTrue(receiptPage.isRechargeAmountSame("10"), "Recharge amount is different on receipt page");
		receiptPage.clickRINLogo();
	}
	
	@Test(priority=16)
	public void testRechargeFlow_PDCRINcashPG(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("mobile");
		landingPage.enterMobileNumber(config.getProperty("Mobile_Number"));
		landingPage.clickSubmitButton2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperator(config.getProperty("Mobile_Operator"));
		landingPage.selectCircle(config.getProperty("Circle"));
		landingPage.clickSubmitButton3();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("10");
		rechargeAmountPage.clickProceedButton();
		
		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("10"), "Payable amount is wrong on payment page");
		paymentPage.enterRINcashAmount("1");
		paymentPage.enterRINPin(config.getProperty("RIN_Pin"));

		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();
		
		Assert.assertTrue(summaryPage.isRINcashApplied("1"), "RINcash is not applied");
		Assert.assertTrue(summaryPage.isPDCapplied(), "Partner Discount Coupon is not displayed on summary page");
		Assert.assertTrue(paymentPage.isPayableAmountPaymentPagePresent("9"), "Payable amount is not shown");
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickRINUrl();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Mobile_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		receiptPage.clickStartAgainButton();
	}
	
	@Test(priority=17)
	public void testRechargeFlow_PromoPG(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("mobile");
		landingPage.enterMobileNumber(config.getProperty("Mobile_Number"));
		landingPage.clickSubmitButton2();
		landingPage.selectConfirmNumberRadioButton();
		landingPage.selectOperator(config.getProperty("Mobile_Operator"));
		landingPage.selectCircle(config.getProperty("Circle"));
		landingPage.clickSubmitButton3();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("10");
		rechargeAmountPage.clickProceedButton();
		
		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("10"), "Payable amount is wrong on payment page");
		paymentPage.clickPDCCheckBox();
		paymentPage.applyPromoCode(config.getProperty("Promo_Code"));
		Assert.assertTrue(paymentPage.isConfirmationAppears(), "No confirmation message appears");
		
		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();
		
		Assert.assertTrue(summaryPage.isAppliedPromoDisplayed(), "Promo code is not applied");
		Assert.assertTrue(paymentPage.isPayableAmountPaymentScen6("9"), "Payable amount is not shown");
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();
		Assert.assertTrue(paymentPage.isNetPayableAmountExpected(), "payable amount on summary page and PDC page are different");
		paymentPage.clickPDCProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickRINUrl();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Mobile_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		receiptPage.clickStartAgainButton();
	}
	

}
