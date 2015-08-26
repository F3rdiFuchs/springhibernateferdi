package com.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name="USER")
public class User {
	private static final int PASSWORD_SECURITY = 2;
	
	@Id
    @GeneratedValue
    @Column(name="USERID")
	private Integer userId;
	
	@NotNull
	@Size(min=5, max=15, message="Must be between 5 and 15 letters")
	@Column(name="USERNAME")
	private String userName;
	
	@Size(max=15)
	@Column(name="NAME")
	private String name;
	
	@Size(max=15)
	@Column(name="LASTNAME")
	private String lastName;
	
	@NotNull
	@Size(max=45)
	@Email
	@Column(name="EMAIL")
	private String eMail;
	
	@NotNull
	@Size(max=150)
	@Column(name="PASSWORD")
	private String passWord;
	
	@NotNull
	private Integer userGroupId;
	
	@ManyToOne
	@JoinColumn(name="GROUPID")
	private Groups groupId;
	
	

	public Integer getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Integer userGroupId) {
		this.userGroupId = userGroupId;
	}

	public Groups getGroupId() {
		return groupId;
	}

	public void setGroupId(Groups groupId) {
		this.groupId = groupId;
	}

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
