package com.example.page.dto.request;

public class ReqJwt {
	private String username;
	private String password;
	
	public ReqJwt() {//constructor for parsing JSON
		
	}
	public ReqJwt(String username,String password) {
		this.username=username;
		this.password=password;		
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
