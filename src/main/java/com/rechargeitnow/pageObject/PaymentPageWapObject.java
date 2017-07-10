package com.rechargeitnow.pageObject;

public class PaymentPageWapObject {
	
	public static String netPayableAmount_Xpath = ".//*[@id='paymentform']/div[1]/ul/li[4]/span";
	public static String PDCCheckbox_Css = ".ui-btn-inner.ui-btn-corner-all";
	public static String proceedButton_Id = "procceed";
	public static String proceedPDCButton_Xpath = "(//input[@value='proceed'])[2]";
	public static String RINcashField_Id = "rincash";
	public static String RINPinField_Id = "newPin";
	public static String promoField_Id = "promoCode";
	public static String applyLink_LinkText = "apply";
	public static String confirmText_Xpath = "//div[contains(text(), 'Congratulations')]";
	public static String netPayableAmount_Id = "withoutone";
	public static String summaryPayableAmountText_Xpath = "//*[@id='paymentform']/div[1]/ul/li[7]";
	public static String summaryPayableAmountTextScen6_xpath = "//*[@id='paymentform']/div[1]/ul/li[6]";
	
	

}
