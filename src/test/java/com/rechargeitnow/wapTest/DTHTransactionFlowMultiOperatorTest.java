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

public class DTHTransactionFlowMultiOperatorTest extends TestCore{
	@Test(priority=0)
	public void testDTHRechargeFlowMultiOperator_PGScen22(){
		String operators = TestCore.config.getProperty("MultiDTH_Operator");
		String strOperators = operators;
		String[] arrSplit = strOperators.split(",");
		for (int i=0; i< arrSplit.length; i++)
		{
			String bankOption = TestCore.config.getProperty("MultiplePayment_Option");
			String strOption = bankOption;
			String[] arrSplit2 = strOption.split(",");
			for(int j=0; j< arrSplit2.length; j++){
				try {
					
					HomePageWap homePage = new HomePageWap(driver);
					homePage.getUrl();
					homePage.clickLuckyDrawCrossIcon();
					homePage.clickLoginButton();

					LoginPageWap loginPage = new LoginPageWap(driver);
					loginPage.enterEmailId(config.getProperty("emailId"));
					loginPage.enterPassword(config.getProperty("password"));
					loginPage.clickSubmitButton();
					Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");

					LandingPageWap landingPage = new LandingPageWap(driver);
					landingPage.clickRechargeTypeButton("dth");
					landingPage.selectDTHOperator(arrSplit[i]);
					landingPage.enterDTHNumberMulti(arrSplit[i]);
					landingPage.clickDTHSubmitButton();

					MobileRechargeAmountPageWap rechargeAmountPage = new MobileRechargeAmountPageWap(driver);
					Assert.assertTrue(rechargeAmountPage.isMultiDTHNumberCorrect(arrSplit[i]), "Mobile number is wrong on recharge amount page");
					rechargeAmountPage.enterRechargeAmount(config.getProperty("MultiDTHRecharge_Amount"));
					rechargeAmountPage.clickProceedButton();
					rechargeAmountPage.clickOKButton();

					PaymentPageWap paymentPage = new PaymentPageWap(driver);
					Assert.assertTrue(paymentPage.isRechargeAmountExpected("100"), "Recharge amount is wrong on payment page");
					paymentPage.clickPDCCheckBox();
					SummaryPageWap summaryPage = new SummaryPageWap(driver);
					summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), arrSplit2[j]);
					paymentPage.clickProceedButton();
					summaryPage.selectPaymentOption(config.getProperty("Payment_Method"), arrSplit2[j]);
					paymentPage.clickProceedButton();
					paymentPage.clickPDCProceedButton();

					PaymentGatewayPage pg = new PaymentGatewayPage(driver);
					pg.clickUseNewCard();
					pg.clickRINUrl();
					homePage.clickLuckyDrawCrossIcon2();

					ReceiptPageWap receiptPage = new ReceiptPageWap(driver);
					Assert.assertTrue(receiptPage.isFailedConfirmationPresent(), "User is redirected to wrong page");
					Assert.assertTrue(receiptPage.isOrderIdPresentScen1(), "Order Id is missing");
					Assert.assertTrue(receiptPage.isMultiDTHNoSameScen1(arrSplit[i]), "Recharged mobile no. is not correct");
					Assert.assertTrue(receiptPage.isRechargeAmountSameScen1(), "Recharge amount is different on receipt");
					
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

}
