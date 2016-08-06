package com.hms.model;

public class UserTO {

	private String username;
	private String passWord;

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		username = userName;
	}

	public String getPassword() {
		return passWord;
	}

	public void setPassword(String password) {
		passWord = password;
	}

	public UserTO(String userName, String password) {
		super();
		username = userName;
		passWord = password;
	}

	public UserTO() {
		super();
	}

}
