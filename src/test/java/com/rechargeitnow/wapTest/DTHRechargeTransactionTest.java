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

public class DTHRechargeTransactionTest extends TestCore{
	
	@Test(priority=0)
	public void testDTHRechargeFlow_CouponPromoRINcashPGScen4(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("dth");
		landingPage.selectDTHOperator(config.getProperty("DTH_Operator"));
		landingPage.enterDTHNumber(config.getProperty("DTH_Number"));
		landingPage.clickDTHSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("DTH_Number")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("250");
		rechargeAmountPage.applyCouponCode(config.getProperty("Coupon_No"), config.getProperty("Coupon_Amount"), config.getProperty("Coupon_Code"));
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickYesRadioButton();
		rechargeAmountPage.clickOKButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("240"), "Payable amount is wrong on payment page");
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
		Assert.assertTrue(paymentPage.isPayableAmountPaymentPagePresent("238"), "Payable amount is not shown");
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
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("DTH_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		Assert.assertTrue(receiptPage.verifyReceiptCouponValueLoc3(), "Coupon value is not applied ");
	}
	
	@Test(priority=1)
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
		landingPage.clickRechargeTypeButton("dth");
		landingPage.selectDTHOperator(config.getProperty("DTH_Operator"));
		landingPage.enterDTHNumber(config.getProperty("DTH_Number"));
		landingPage.clickDTHSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("DTH_Number")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("250");
		rechargeAmountPage.applyCouponCode(config.getProperty("Coupon_No"), config.getProperty("Coupon_Amount"), config.getProperty("Coupon_Code"));
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickYesRadioButton();
		rechargeAmountPage.clickOKButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("240"), "Payable amount is wrong on payment page");
		paymentPage.clickPDCCheckBox();
		paymentPage.applyPromoCode(config.getProperty("Promo_Code"));
		Assert.assertTrue(paymentPage.isConfirmationAppears(), "No confirmation message appears");

		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		Assert.assertTrue(summaryPage.isAppliedPromoDisplayed(), "Promo code is not applied");
		Assert.assertTrue(paymentPage.isPayableAmountPaymentScen6("239"), "Payable amount is not shown");
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
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("DTH_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		Assert.assertTrue(receiptPage.verifyReceiptCouponValueLoc3(), "Coupon value is not applied ");
		
	}
	@Test(priority=2)
	public void testDTHRechargeFlow_CouponPDCPromoPGScen7(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("dth");
		landingPage.selectDTHOperator(config.getProperty("DTH_Operator"));
		landingPage.enterDTHNumber(config.getProperty("DTH_Number"));
		landingPage.clickDTHSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("DTH_Number")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("250");
		rechargeAmountPage.applyCouponCode(config.getProperty("Coupon_No"), config.getProperty("Coupon_Amount"), config.getProperty("Coupon_Code"));
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickYesRadioButton();
		rechargeAmountPage.clickOKButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("240"), "Payable amount is wrong on payment page");
		paymentPage.applyPromoCode(config.getProperty("Promo_Code"));
		Assert.assertTrue(paymentPage.isConfirmationAppears(), "No confirmation message appears");

		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		Assert.assertTrue(summaryPage.isPDCapplied(), "Partner Discount Coupon is not applied");
		Assert.assertTrue(summaryPage.isPromoApplied(), "Promo code is not applied");
		Assert.assertTrue(paymentPage.isPayableAmountPaymentPagePresent("249"), "Payable amount is not shown");
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("DTH_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		Assert.assertTrue(receiptPage.verifyReceiptCouponValueLoc3(), "Coupon value is not applied ");
	
	}
	
	@Test(priority=3)
	public void testDTHRechargeFlow_CouponRINcashPGScen8(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("dth");
		landingPage.selectDTHOperator(config.getProperty("DTH_Operator"));
		landingPage.enterDTHNumber(config.getProperty("DTH_Number"));
		landingPage.clickDTHSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("DTH_Number")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("250");
		rechargeAmountPage.applyCouponCode(config.getProperty("Coupon_No"), config.getProperty("Coupon_Amount"), config.getProperty("Coupon_Code"));
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickYesRadioButton();
		rechargeAmountPage.clickOKButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("240"), "Payable amount is wrong on payment page");
		paymentPage.clickPDCCheckBox();
		paymentPage.enterRINcashAmount("1");
		paymentPage.enterRINPin(config.getProperty("RIN_Pin"));

		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		Assert.assertTrue(summaryPage.isRINcashApplied("1"), "RINcash is not applied");
		Assert.assertTrue(paymentPage.isPayableAmountPaymentScen6("239"), "Payable amount is not shown");
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
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("DTH_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		Assert.assertTrue(receiptPage.verifyReceiptCouponValueLoc3(), "Coupon value is not applied ");
	}
	
	@Test(priority=4)
	public void testDTHRechargeFlow_CouponPDCRINcashPGScen9(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("dth");
		landingPage.selectDTHOperator(config.getProperty("DTH_Operator"));
		landingPage.enterDTHNumber(config.getProperty("DTH_Number"));
		landingPage.clickDTHSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("DTH_Number")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("250");
		rechargeAmountPage.applyCouponCode(config.getProperty("Coupon_No"), config.getProperty("Coupon_Amount"), config.getProperty("Coupon_Code"));
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickYesRadioButton();
		rechargeAmountPage.clickOKButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("240"), "Payable amount is wrong on payment page");
		paymentPage.enterRINcashAmount("1");
		paymentPage.enterRINPin(config.getProperty("RIN_Pin"));

		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		Assert.assertTrue(summaryPage.isPDCapplied(), "Partner Discount Coupon is not applied");
		Assert.assertTrue(summaryPage.isRINcashAppliedPDC(), "RINcash is not applied");
		Assert.assertTrue(paymentPage.isPayableAmountPaymentPagePresent("249"), "Payable amount is not shown");
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("DTH_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		Assert.assertTrue(receiptPage.verifyReceiptCouponValueLoc3(), "Coupon value is not applied ");
	}
	
	@Test(priority=5)
	public void testDTHRechargeFlow_RINPGScen14(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("dth");
		landingPage.selectDTHOperator(config.getProperty("DTH_Operator"));
		landingPage.enterDTHNumber(config.getProperty("DTH_Number"));
		landingPage.clickDTHSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("DTH_Number")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("250");
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickOKButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("250"), "Payable amount is wrong on payment page");
		paymentPage.clickPDCCheckBox();
		paymentPage.enterRINcashAmount("1");
		paymentPage.enterRINPin(config.getProperty("RIN_Pin"));
		
		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		Assert.assertTrue(summaryPage.isRINcashApplied("1"), "RINcash is not applied");
		Assert.assertTrue(paymentPage.isPayableAmountPaymentScen6("249"), "Payable amount is not shown");
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
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("DTH_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
	}
	@Test(priority=6)
	public void testDTHRechargeFlow_RINcashPromoPGScen17(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("dth");
		landingPage.selectDTHOperator(config.getProperty("DTH_Operator"));
		landingPage.enterDTHNumber(config.getProperty("DTH_Number"));
		landingPage.clickDTHSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("DTH_Number")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("250");
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickOKButton();
		
		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("250"), "Payable amount is wrong on payment page");
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
		Assert.assertTrue(paymentPage.isPayableAmountPaymentPagePresent("248"), "Payable amount is not shown");
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
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("DTH_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		
	}
	
	@Test(priority=7)
	public void testDTHRechargeFlow_PDCRINcashPGScen19(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("dth");
		landingPage.selectDTHOperator(config.getProperty("DTH_Operator"));
		landingPage.enterDTHNumber(config.getProperty("DTH_Number"));
		landingPage.clickDTHSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("DTH_Number")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("250");
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickOKButton();
		
		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("250"), "Payable amount is wrong on payment page");
		paymentPage.enterRINcashAmount("1");
		paymentPage.enterRINPin(config.getProperty("RIN_Pin"));

		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();
		
		Assert.assertTrue(summaryPage.isRINcashApplied("1"), "RINcash is not applied");
		Assert.assertTrue(summaryPage.isPDCapplied(), "Partner Discount Coupon is not displayed on summary page");
		Assert.assertTrue(paymentPage.isPayableAmountPaymentPagePresent("259"), "Payable amount is not shown");
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("DTH_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
	}
	
	@Test(priority=8)
	public void testDTHRechargeFlow_PromoPGScen20(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("dth");
		landingPage.selectDTHOperator(config.getProperty("DTH_Operator"));
		landingPage.enterDTHNumber(config.getProperty("DTH_Number"));
		landingPage.clickDTHSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("DTH_Number")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("250");
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickOKButton();
		
		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("250"), "Payable amount is wrong on payment page");
		paymentPage.clickPDCCheckBox();
		paymentPage.applyPromoCode(config.getProperty("Promo_Code"));
		Assert.assertTrue(paymentPage.isConfirmationAppears(), "No confirmation message appears");
		
		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();
		
		Assert.assertTrue(summaryPage.isAppliedPromoDisplayed(), "Promo code is not applied");
		Assert.assertTrue(paymentPage.isPayableAmountPaymentScen6("249"), "Payable amount is not shown");
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
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("DTH_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
	}
	@Test(priority=9)
	public void testDTHRechargeFlow_PDCPromoPGScen21(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("dth");
		landingPage.selectDTHOperator(config.getProperty("DTH_Operator"));
		landingPage.enterDTHNumber(config.getProperty("DTH_Number"));
		landingPage.clickDTHSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("DTH_Number")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("250");
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickOKButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("250"), "Payable amount is wrong on payment page");
		paymentPage.applyPromoCode(config.getProperty("Promo_Code"));
		Assert.assertTrue(paymentPage.isConfirmationAppears(), "No confirmation message appears");

		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		Assert.assertTrue(summaryPage.isPDCapplied(), "Partner Discount Coupon is not applied");
		Assert.assertTrue(summaryPage.isPromoApplied(), "Promo is not applied");
		Assert.assertTrue(paymentPage.isPayableAmountPaymentPagePresent("259"), "Payable amount is not shown");
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("DTH_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");

	}
	@Test(priority=10)
	public void testDTHRechargeFlow_PGScen22(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("dth");
		landingPage.selectDTHOperator(config.getProperty("DTH_Operator"));
		landingPage.enterDTHNumber(config.getProperty("DTH_Number"));
		landingPage.clickDTHSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("DTH_Number")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("250");
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickOKButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("250"), "Recharge amount is wrong on payment page");
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
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("DTH_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");

	}
	@Test(priority=11)
	public void testDTHRechargeFlow_CouponPGScen23(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("dth");
		landingPage.selectDTHOperator(config.getProperty("DTH_Operator"));
		landingPage.enterDTHNumber(config.getProperty("DTH_Number"));
		landingPage.clickDTHSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("DTH_Number")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("250");
		rechargeAmountPage.applyCouponCode(config.getProperty("Coupon_No"), config.getProperty("Coupon_Amount"), config.getProperty("Coupon_Code"));
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickYesRadioButton();
		rechargeAmountPage.clickOKButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("240"), "Payable amount is wrong on payment page");
		paymentPage.clickPDCCheckBox();

		SummaryPageWap summaryPage = new SummaryPageWap(driver);
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
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("DTH_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		Assert.assertTrue(receiptPage.verifyReceiptCouponValueLoc3(), "Coupon value is not applied ");
	}

	@Test(priority=12)
	public void testDTHRechargeFlow_PGandPDCScen24(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("dth");
		landingPage.selectDTHOperator(config.getProperty("DTH_Operator"));
		landingPage.enterDTHNumber(config.getProperty("DTH_Number"));
		landingPage.clickDTHSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("DTH_Number")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("250");
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickOKButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("250"), "Payable amount is wrong on payment page");

		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();
		paymentPage.clickProceedButtonWithPDC();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("DTH_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
	}
	@Test(priority=13)
	public void testDTHRechargeFlow_CouponPDCandPGScen25(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("dth");
		landingPage.selectDTHOperator(config.getProperty("DTH_Operator"));
		landingPage.enterDTHNumber(config.getProperty("DTH_Number"));
		landingPage.clickDTHSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("DTH_Number")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("250");
		rechargeAmountPage.applyCouponCode(config.getProperty("Coupon_No"), config.getProperty("Coupon_Amount"), config.getProperty("Coupon_Code"));
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickYesRadioButton();
		rechargeAmountPage.clickOKButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("240"), "Payable amount is wrong on payment page");

		SummaryPageWap summaryPage = new SummaryPageWap(driver);
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();
		paymentPage.clickProceedButtonWithPDC();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("DTH_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
	}
	
	@Test(priority=14)
	public void testDTHRechargeFlow_CpnPDCPromoRINandPGScen26(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("dth");
		landingPage.selectDTHOperator(config.getProperty("DTH_Operator"));
		landingPage.enterDTHNumber(config.getProperty("DTH_Number"));
		landingPage.clickDTHSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("DTH_Number")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("250");
		rechargeAmountPage.applyCouponCode(config.getProperty("Coupon_No"), config.getProperty("Coupon_Amount"), config.getProperty("Coupon_Code"));
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickYesRadioButton();
		rechargeAmountPage.clickOKButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("240"), "Payable amount is wrong on payment page");
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
		Assert.assertTrue(paymentPage.isPayableAmountPaymentData2("248"), "Payable amount is not shown");
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("DTH_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
		Assert.assertTrue(receiptPage.verifyReceiptCouponValueLoc3(), "Coupon value is not applied ");
	}
	@Test(priority=15)
	public void testDTHRechargeFlow_RINcashPGPromoAndPDCScen31(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();

        LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

		LandingPageWap landingPage = new LandingPageWap(driver);
		landingPage.clickRechargeTypeButton("dth");
		landingPage.selectDTHOperator(config.getProperty("DTH_Operator"));
		landingPage.enterDTHNumber(config.getProperty("DTH_Number"));
		landingPage.clickDTHSubmitButton();

		MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
		Assert.assertTrue(rechargeAmountPage.isMobileNumberCorrect(config.getProperty("DTH_Number")), "Mobile number is wrong on recharge amount page");
		rechargeAmountPage.enterRechargeAmount("250");
		rechargeAmountPage.clickProceedButton();
		rechargeAmountPage.clickOKButton();

		PaymentPageWap paymentPage = new PaymentPageWap(driver);
		Assert.assertTrue(paymentPage.isRechargeAmountExpected("250"), "Payable amount is wrong on payment page");
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
		Assert.assertTrue(paymentPage.isPayableAmountPaymentData2("258"), "Payable amount is not shown");
		summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), config.getProperty("Payment_Option"));
		paymentPage.clickProceedButton();

		PaymentGatewayPage pg = new PaymentGatewayPage(driver);
		pg.clickUseNewCard();
		pg.clickRINUrl();
		homePage.clickLuckyDrawCrossIcon2();

		ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
		Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
		Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
		Assert.assertTrue(receiptPage.isMobileNoSameScen1(config.getProperty("DTH_Number")), "Recharged mobile no. is not correct");
		Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
	}

}
