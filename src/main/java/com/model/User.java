package com.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class User {
	private Integer 	userId;
	private String		userName;
	private String 		name;
	private String 		lastName;
	private String 		eMail;
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
	@NotNull
	@Size(min=5, max=15)
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	
	@Size(max=15)
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	
	@Size(max=15)
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String geteMail() {
		return eMail;
	}
	
	@NotNull
	@Size(max=45)
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPassWord() {
		return passWord;
	}
	
	@NotNull
	@Size(max=150)
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
