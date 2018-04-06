package com.etc.bean;

public class Auth {
	private int authId;
	private String authName;

	public Auth() {
		super();
	}

	public Auth(int authId, String authName) {
		super();
		this.authId = authId;
		this.authName = authName;
	}

	public int getAuthId() {
		return authId;
	}

	public void setAuthId(int authId) {
		this.authId = authId;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}
}
