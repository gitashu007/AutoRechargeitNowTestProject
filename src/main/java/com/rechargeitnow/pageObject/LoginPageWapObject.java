package com.rechargeitnow.pageObject;

public class LoginPageWapObject {
	
	public static String emailIdField_Id = "emailId";
	public static String passwordField_Id = "passwordId";
	public static String submitButton_xpath = "//input[@onclick='loginSubmitfunction()']";
	public static String logoutButtonField_xpath = ".//*[@id='logoutShowId']/a";
	public static String errorMessage_Id = "errorSpan";
	public static String registerButton_Xpath = "//input[@value='register']";
	public static String facebookLogo_Xpath = "//span[contains(text(), 'Log in to Facebook')]";
	public static String fbEmailIdField_Id = "email";
	public static String fbPasswordField_Id = "pass";
	public static String fbLoginButton_Id = "loginbutton";
	public static String facebookIcon_Xpath = "//img[@src='/resources/images/ico-facebook.jpg']";
	public static String yahooIcon_Xpath = "//img[@src='/resources/images/ico-yahoo.jpg']";
	public static String gPlusIcon_Xpath = "//img[@src='/resources/images/ico-google.jpg']";
	public static String linkedInIcon_Xpath = "//img[@src='/resources/images/ico-linkedin.jpg']";
	public static String gPlusEmailField_Id = "identifierId";
	public static String gPlusNextButton_Id = "//span[contains(text(), 'Next')]";
	public static String gPlusPasswordField_Xpath = "//input[@aria-label='Enter your password']";
	public static String yahooEmailIdField_Id = "login-username";
	public static String yahooNextButton_Xpath = "//input[@value='Next']";
	public static String yahooPasswordField_Id = "login-passwd";
	public static String yahooSignInButton_Id = "login-signin";
	public static String yahooAgreeButton_Id = "agree";
	public static String linkedInEmailIdField_Id = "session_key-oauthAuthorizeForm";
	public static String linkedInPasswordField_Id = "session_password-oauthAuthorizeForm";
	public static String linkedInAllowAccessButton_Xpath = "//*[@id='body']/div/form/div[2]/ul/li[1]/input"; 
	
	

}
