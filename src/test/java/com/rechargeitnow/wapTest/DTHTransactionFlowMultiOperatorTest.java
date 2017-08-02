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
		for (int i=0; i< arrSplit.length; i++){

			String bankMethod = TestCore.config.getProperty("MultiPayment_Method");
			String strPayment = bankMethod;
			String[] arrPaymentMethod = strPayment.split(",");
			for(int k=0; k< arrPaymentMethod.length; k++){

				String bankOption = TestCore.config.getProperty("MultiplePayment_Option");
				String strOption = bankOption;
				String[] arrSplit2 = strOption.split(",");
				if(arrPaymentMethod[k].equals("Credit Card")){
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
							Assert.assertTrue(paymentPage.isRechargeAmountExpected(config.getProperty("MultiDTHRecharge_Amount")), "Recharge amount is wrong on payment page");
							paymentPage.clickPDCCheckBox();
							SummaryPageWap summaryPage = new SummaryPageWap(driver);
							summaryPage.selectPaymentOption(arrPaymentMethod[k], arrSplit2[j]);
							paymentPage.clickProceedButton();
							summaryPage.selectPaymentOption(arrPaymentMethod[k], arrSplit2[j]);
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
				else {
					String bankOption2 = TestCore.config.getProperty("MultipleDebitPayment_Option");
					String strOption2 = bankOption2;
					String[] arrDebitOption = strOption2.split(",");
					for(int j=0; j< arrDebitOption.length; j++){
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
							Assert.assertTrue(paymentPage.isRechargeAmountExpected(config.getProperty("MultiDTHRecharge_Amount")), "Recharge amount is wrong on payment page");
							paymentPage.clickPDCCheckBox();
							SummaryPageWap summaryPage = new SummaryPageWap(driver);
							summaryPage.selectPaymentOption(arrPaymentMethod[k], arrDebitOption[j]);
							paymentPage.clickProceedButton();
							summaryPage.selectPaymentOption(arrPaymentMethod[k], arrDebitOption[j]);
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
	}
}
