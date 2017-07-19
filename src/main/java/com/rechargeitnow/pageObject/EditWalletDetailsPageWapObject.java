package com.rechargeitnow.pageObject;

public class EditWalletDetailsPageWapObject {
	public static String editMobileNoTab_Xpath = ".//*[@id='skltbsResponsive1Tab']";
	public static String editPinTab_Xpath = "//*[@id='skltbsResponsive2Tab']";
	public static String newMobileNoField_Xpath = "//*[@id='strRegMobileNo']";
	public static String pinNumberField_Xpath = "//*[@id='strMobilePin']";
	public static String currentMobileNumberText_Xpath = "//input[@placeholder='current mobile no.']";
	public static String proceedButton_Xpath = "//*[@id='formmobile']/div[8]/div/button";
	public static String oldPinField_Id = "strPin";
	public static String newPinField_Id = "strNewPin";
	public static String confirmPin_Id = "strDupPin";
	public static String pinProceedButton_Xpath = "//button[@onclick='submitPinRequest();']";
	public static String confirmPinText_Xpath = "//strong[contains(text(), 'Congratulations')]";
	public static String confirmOKButton_Xpath = "//button[@onclick='showwallethistory();']";
	public static String currentMobNo_Xpath = "//*[@id='strCurMobileNo']";
	public static String validationText_Xpath = "//*[@id='error1']";
	public static String editMobValidationText_Id = "edit_mobile";
	public static String pinValidation_Xpath = "//*[@id='error']";
	public static String pinValidationMessageUp_Id = "edit_pin";
	

}
