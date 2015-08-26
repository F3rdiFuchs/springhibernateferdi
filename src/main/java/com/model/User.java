package com.model;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class User {
	private static final int PASSWORD_SECURITY = 2;
	
	@Id
    @GeneratedValue
    @Column(name="userId")
	private Integer userId;
	
	@NotNull
	@Size(min=5, max=15, message="Must be between 5 and 15 letters")
	@Column(name="userName")
	private String userName;
	
	@Size(max=15)
	@Column(name="name")
	private String name;
	
	@Size(max=15)
	@Column(name="lastName")
	private String lastName;
	
	@NotNull
	@Size(max=45)
	@Email
	@Column(name="eMail")
	private String eMail;
	
	@NotNull
	@Size(max=150)
	@Column(name="passWord")
	private String passWord;
	
	@ManyToOne
	@JoinColumn(name="groupId", insertable=false, updatable=false, nullable=false)
	private Integer groupId;
	
	
	
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
	
	@Override
	public String toString()
	{
		return this.userName;
	}
}
