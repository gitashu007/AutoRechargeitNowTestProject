package com.rechargeitnow.pageObject;

public class LandingPageWapObject {
	
	public static String mobileNumberField_Xpath = "//input[@placeholder='enter mobile number']";
	public static String mobileNumberFieldData_Id = "dataMobileNoIds";
	public static String submitButton_Xpath = "//input[@onclick='return fmnpFirstSubmit()']";
	public static String submitButtonData2_Xpath = "//input[@onclick='datafmnpSubmit()']";
	public static String confirmNumberRadioButton_Xpath = "//input[@value='YES']";
	public static String confirmYesButton_Xpath = "//span[contains(text(), 'yes')]";
	public static String selectOperatorDropdown_Xpath = "//*[@id='s2id_mobileOperatorId']/a/span[2]/b";
	public static String selectCircleDropdown_Id = "mobileCircleId";
	public static String circleDropdownData_Xpath = "//select[@name='circleid']";
	public static String submitButton3_Xpath = "//input[@onclick='SubmitMobile()']";
	public static String selectOperatorDropdownData_Css = "#select2-chosen-2";
	public static String submitButtonData_xpath = "//input[@onclick='SubmitMobile()']";
	public static String submitDataButtonPrepaid_Xpath = "//input[@onclick='DataSubmitRequest()']";
	public static String dataRechargetypeButton_Xpath = "//*[@id='dataFmnp']/h3/a/span/span[1]";
	public static String postpaidMobileNumberField_Xpath = "//input[@placeholder='enter postpaid mobile number']";
	public static String postpaidOperator_Id = "billpayOperatorId";
	public static String postpaidSubmitButton_Id = "submit3";
	public static String DTHOperator_Id = "dthServiceProviderId";
	public static String prepaidNumberSubmitButoon_Xpath = "//input[@onclick='adminProjectFilterRequest()']";
	
	public static String airtelDTHNumberField_Id = "dthSubscriberID_36";
	public static String dishDTHNumberField_Id = "dthSubscriberID_17";
	public static String relianceDTHNumberField_Id = "dthSubscriberID_35";
	public static String sunDirectDTHNumberField_Id = "dthSubscriberID_21";
	public static String tataNumberField_Id = "dthSubscriberID_19";
	public static String videoconDTHNumberField_Id = "dthSubscriberID_27";
	public static String DTHSubmitButton_Xpath = "//input[@onclick='DthSubmitRequest()']";
	
	
	
}
