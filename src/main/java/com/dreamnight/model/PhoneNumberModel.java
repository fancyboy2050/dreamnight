package com.dreamnight.model;

public class PhoneNumberModel extends BaseObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3985568603254150605L;
	private String areaCode;
	private String phoneNumber;
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
