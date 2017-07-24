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

public class PostpaidBillPayTransactionFlowTest extends TestCore{
	
	/*@Test(priority=0)
	public void testPostpaidBillPayFlow_couponScen1(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("10");
		rechargeAmountPage.applyCouponCode(config.getProperty("Coupon_No"), config.getProperty("Coupon_Amount"), config.getProperty("Coupon_Code"));
		rechargeAmountPage.clickProceedButton();

		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		Assert.assertTrue(summaryPage.verifyNetPayableAmount("0"), "Verification of net amount is failed");
		summaryPage.clickProceedSummaryButton();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		receiptPage.clickHereToStopLink();
	    Assert.assertTrue(receiptPage.isOrderIdPresent(), "Order id is not present on receipt");
	    Assert.assertTrue(receiptPage.isMobileNoSame(config.getProperty("Postpaid_MobileNumber")),"Mobile no. is different on receipt page");
	    Assert.assertTrue(receiptPage.isRechargeAmountSame("10"), "Recharge amount is different on receipt page");
	    Assert.assertTrue(receiptPage.verifyCouponValue(), "verification of Coupon is failed");
	}
	
	@Test(priority=1)
	public void testPostpaidBillPayFlow_CouponRINcashScen2(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
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
		Assert.assertTrue(receiptPage.isMobileNoSame(config.getProperty("Postpaid_MobileNumber")),"Mobile no. is different on receipt page");
		Assert.assertTrue(receiptPage.isRechargeAmountSame("15"), "Recharge amount is different on receipt page");
		Assert.assertTrue(receiptPage.isRINcashPointDisplayed("5"), "RINcash points are not displayed");
		Assert.assertTrue(receiptPage.verifyReceiptCouponValue(), "Coupon value is not applied ");
		
	}

	@Test(priority=2)
	public void testPostpaidBillPayFlow_CouponPromoRINcashScen3(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
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
		Assert.assertTrue(receiptPage.isMobileNoSame(config.getProperty("Postpaid_MobileNumber")),"Mobile no. is different on receipt page");
		Assert.assertTrue(receiptPage.isRechargeAmountSame("15"), "Recharge amount is different on receipt page");
		Assert.assertTrue(receiptPage.isRINcashPointDisplayed("4"), "RINcash points are not displayed");
		Assert.assertTrue(receiptPage.isPromoDiscountDisplayed("1"), "Promo amount are not displayed");
		Assert.assertTrue(receiptPage.verifyReceiptCouponValueLoc2(), "Coupon value is not applied ");
	
	}

	@Test(priority=3)
	public void testPostpaidBillPayFlow_CouponPromoRINcashPGScen4(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
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
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();
		
		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Postpaid_MobileNumber")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		Assert.assertTrue(receiptPage.verifyReceiptCouponValueLoc3(), "Coupon value is not applied ");

	}

	@Test(priority=4)
	public void testPostpaidBillPayFlow_CouponPromoPGScen6(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();
		
		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
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
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Postpaid_MobileNumber")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		Assert.assertTrue(receiptPage.verifyReceiptCouponValueLoc3(), "Coupon value is not applied ");
	}

	@Test(priority=5)
	public void testPostpaidBillPayFlow_CouponPDCPromoPGScen7(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
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
		Assert.assertTrue(paymentPage.isPayableAmountPaymentPagePresent("14"), "Payable amount is not shown");
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Postpaid_MobileNumber")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		Assert.assertTrue(receiptPage.verifyReceiptCouponValueLoc3(), "Coupon value is not applied ");
	
	}

	@Test(priority=6)
	public void testPostpaidBillPayFlow_CouponRINcashPGScen8(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
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
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Postpaid_MobileNumber")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		Assert.assertTrue(receiptPage.verifyReceiptCouponValueLoc3(), "Coupon value is not applied ");
	}

	@Test(priority=7)
	public void testPostpaidBillPayFlow_CouponPDCRINcashPGScen9(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
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
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Postpaid_MobileNumber")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		Assert.assertTrue(receiptPage.verifyReceiptCouponValueLoc3(), "Coupon value is not applied ");
	}

	@Test(priority=8)
	public void testPostpaidBillPayFlow_CouponRincashPromoPDCScen10(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
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
		Assert.assertTrue(receiptPage.isMobileNoSame(config.getProperty("Postpaid_MobileNumber")),"Mobile no. is different on receipt page");
		Assert.assertTrue(receiptPage.isRechargeAmountSame("15"), "Recharge amount is different on receipt page");
		Assert.assertTrue(receiptPage.isRINcashPointDisplayed("14"), "RINcash points are not displayed");
		Assert.assertTrue(receiptPage.isPromoDiscountDisplayed("1"), "Promo discount is not displayed");
		Assert.assertTrue(receiptPage.verifyReceiptCouponValueLoc2(), "Coupon value is not applied ");
	}

	@Test(priority=9)
	public void testPostpaidBillPayFlow_RINcashScen12(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("10");
		rechargeAmountPage.clickProceedButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("10"), "Payable amount is wrong on payment page");
		paymentPage.clickPDCCheckBox();
		paymentPage.enterRINcashAmount("10");
		paymentPage.enterRINPin(config.getProperty("RIN_Pin"));
		paymentPage.clickProceedButton();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		receiptPage.clickHereToStopLink();
		Assert.assertTrue(receiptPage.isOrderIdPresent(), "Order id is not present on receipt");
		Assert.assertTrue(receiptPage.isMobileNoSame(config.getProperty("Postpaid_MobileNumber")),"Mobile no. is different on receipt page");
		Assert.assertTrue(receiptPage.isRechargeAmountSame("10"), "Recharge amount is different on receipt page");
		Assert.assertTrue(receiptPage.isRINcashPointDisplayed("10"), "RINcash points are not displayed");

	}

	@Test(priority=10)
	public void testPostpaidBillPayFlow_RINPromoScen13(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
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
		Assert.assertTrue(receiptPage.isMobileNoSame(config.getProperty("Postpaid_MobileNumber")),"Mobile no. is different on receipt page");
		Assert.assertTrue(receiptPage.isRechargeAmountSame("10"), "Recharge amount is different on receipt page");
		Assert.assertTrue(receiptPage.isRINcashPointDisplayed("9"), "RINcash points are not displayed");
		Assert.assertTrue(receiptPage.isPromoDiscountDisplayed("1"), "Promo discount is not displayed");

	}*/

	@Test(priority=11)
	public void testPostpaidBillPayFlow_RINPGScen14(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
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
		Assert.assertTrue(paymentPage.isNetPayableAmountExpected(), "payable amount on summary page and PDC page are different");
		paymentPage.clickPDCProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Postpaid_MobileNumber")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
	}

	@Test(priority=12)
	public void testPostpaidBillPayFlow_RINcashPDCScen15(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
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
		Assert.assertTrue(receiptPage.isMobileNoSame(config.getProperty("Postpaid_MobileNumber")),"Mobile no. is different on receipt page");
		Assert.assertTrue(receiptPage.isRechargeAmountSame("10"), "Recharge amount is different on receipt page");
		Assert.assertTrue(receiptPage.isRINcashPointDisplayed("20"), "RINcash points are not displayed");
	}
	
	@Test(priority=13)
	public void testPostpaidBillPayFlow_CouponRINcashPDCScen16(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
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
		Assert.assertTrue(receiptPage.isMobileNoSame(config.getProperty("Postpaid_MobileNumber")),"Mobile no. is different on receipt page");
		Assert.assertTrue(receiptPage.isRechargeAmountSame("15"), "Recharge amount is different on receipt page");
		Assert.assertTrue(receiptPage.isRINcashPointDisplayed("15"), "RINcash points are not displayed");
		Assert.assertTrue(receiptPage.verifyReceiptCouponValue(), "Coupon value is not shown");
		
	}
	@Test(priority=14)
	public void testPostpaidBillPayFlow_RINcashPromoPGScen17(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
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
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Postpaid_MobileNumber")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		
	}
	
	@Test(priority=15)
	public void testPostpaidBillPayFlow_RINcashPromoPDCScen18(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
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
		Assert.assertTrue(receiptPage.isMobileNoSame(config.getProperty("Postpaid_MobileNumber")),"Mobile no. is different on receipt page");
		Assert.assertTrue(receiptPage.isRechargeAmountSame("10"), "Recharge amount is different on receipt page");
		Assert.assertTrue(receiptPage.isRINcashPointDisplayed("19"), "RINcash points are not displayed");
	}
	
	@Test(priority=16)
	public void testPostpaidBillPayFlow_PDCRINcashPGScen19(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
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
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Postpaid_MobileNumber")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
	}
	
	@Test(priority=17)
	public void testPostpaidBillPayFlow_PromoPGScen20(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
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
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Postpaid_MobileNumber")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
	}
	@Test(priority=18)
	public void testPostpaidBillPayFlow_PDCPromoPGScen21(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
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
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Postpaid_MobileNumber")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");

	}
	@Test(priority=19)
	public void testPostpaidBillPayFlow_PGScen22(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
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
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();
		
		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Postpaid_MobileNumber")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");

	}
	@Test(priority=20)
	public void testPostpaidBillPayFlow_CouponPGScen23(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
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
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Postpaid_MobileNumber")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		Assert.assertTrue(receiptPage.verifyReceiptCouponValueLoc3(), "Coupon value is not applied ");
	}

	@Test(priority=21)
	public void testPostpaidBillPayFlow_PGandPDCScen24(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
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
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Postpaid_MobileNumber")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
	}
	@Test(priority=22)
	public void testPostpaidBillPayFlow_CouponPDCandPGScen25(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
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
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Postpaid_MobileNumber")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
	}
	
	@Test(priority=23)
	public void testPostpaidBillPayFlow_CpnPDCPromoRINandPGScen26(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
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
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Postpaid_MobileNumber")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		Assert.assertTrue(receiptPage.verifyReceiptCouponValueLoc3(), "Coupon value is not applied ");
	}
	@Test(priority=24)
	public void testPostpaidBillPayFlow_RINcashPGPromoAndPDCScen31(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("postpaid bill pay");
		landingPage.selectPostpaidOperator(config.getProperty("Postpaid_Operator"));
		landingPage.enterPostpaidMobileNo(config.getProperty("Postpaid_MobileNumber"));
		landingPage.clickPostpaidSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("Postpaid_MobileNumber")), "Mobile number is wrong on recharge amount page");
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
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("Postpaid_MobileNumber")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
	}
	

}
