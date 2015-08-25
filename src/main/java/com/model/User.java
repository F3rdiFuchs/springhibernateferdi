package com.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class User {
	private Integer 	userId;
	
	@NotNull
	@Size(min=5, max=15, message="Must be between 5 and 15 letters")
	private String		userName;
	
	@Size(max=15)
	private String 		name;
	
	@Size(max=15)
	private String 		lastName;
	
	@NotNull
	@Size(max=45)
	private String 		eMail;
	
	@NotNull
	@Size(max=150)
	private String 		passWord;
	private Integer 	groupId;
	
	private static final int PASSWORD_SECURITY = 2;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String geteMail() {
		return eMail;
	}
	
	
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPassWord() {
		return passWord;
	}
	
	
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public void encryptPasswd() {
		int count = 0;
		while(count < PASSWORD_SECURITY)
		{
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			this.passWord = passwordEncoder.encode(this.passWord);
			count++;
		}
		
	}
}
